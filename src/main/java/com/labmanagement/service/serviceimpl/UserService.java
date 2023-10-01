package com.labmanagement.service.serviceimpl;

import com.labmanagement.configuration.security.JwtService;
import com.labmanagement.model.dao.DirectorDTO;
import com.labmanagement.model.dao.MembreDTO;
import com.labmanagement.model.dao.UserDTO;
import com.labmanagement.model.entity.User;
import com.labmanagement.model.entity.VerificationToken;
import com.labmanagement.repository.UserRepository;
import com.labmanagement.repository.VerificationRepository;
import com.labmanagement.service.IEmailService;
import com.labmanagement.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final VerificationRepository verificationRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;
    private final IEmailService emailService;

    @Override
    public Object login(User userLogin) throws Exception {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        var user = userRepository.findByUsername(userLogin.getUsername()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        user.setToken(jwtToken);

        return getUserTypeObject(user);

    }

    @Override
    public Object register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exist ");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        var savedUser = userRepository.save(user);

        VerificationToken verificationToken = new VerificationToken(user);
        verificationRepository.save(verificationToken);

        emailService.SendSimpleMessage(user.getName(), user.getEmail(), verificationToken.getToken());

        return getUserTypeObject(savedUser);
    }

    @Override
    public Boolean verifyToken(String token) {
        VerificationToken verificationToken = verificationRepository.findByToken(token);
        User user = userRepository.findByEmailIgnoreCase(verificationToken.getUser().getEmail());
        user.setEnabled(true);
        userRepository.save(user);
        return Boolean.TRUE;
    }


    private Object getUserTypeObject(User user) {
        return switch (user.getRole()) {
            case MEMBER -> modelMapper.map(user, MembreDTO.class);
            case DIRECTOR -> modelMapper.map(user, DirectorDTO.class);
            case ADMIN -> modelMapper.map(user, UserDTO.class);
            default -> throw new IllegalArgumentException("Unexpected value: " + user.getRole());
        };
    }

}
