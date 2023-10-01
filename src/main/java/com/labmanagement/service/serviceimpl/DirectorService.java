package com.labmanagement.service.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.labmanagement.model.dao.DirectorDTO;
import com.labmanagement.model.entity.Director;
import com.labmanagement.model.entity.Laboratoire;
import com.labmanagement.repository.DirectorRepository;
import com.labmanagement.service.IDirectorService;
import com.labmanagement.service.ILaboratoireService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DirectorService implements IDirectorService {

	private final DirectorRepository directorRepository;
	private final ILaboratoireService laboratoireService;
	private final PasswordEncoder passwordEncoder;
	private final ModelMapper modelMapper;

	@Override
	public List<DirectorDTO> getAllDirectors() {

		List<Director> directors = directorRepository.findAll();
		List<DirectorDTO> DirectorDTOs = directors.stream()
				.map(director -> modelMapper.map(director, DirectorDTO.class)).collect(Collectors.toList());
		return DirectorDTOs;
	}

	@Override
	public DirectorDTO getDirectorById(Long id) {
		Director director = directorRepository.findById(id).orElse(null);
		return modelMapper.map(director, DirectorDTO.class);
	}

	@Override
	public DirectorDTO saveDirector(Director director) {

		Laboratoire lab = laboratoireService.findLaboratoireById(director.getLaboratoire().getId());
		director.setPassword(passwordEncoder.encode(director.getPassword()));
		Director savedDirector = directorRepository.save(director);
		lab.setDirector(savedDirector);
		laboratoireService.updateLaboratoire(lab);

		return modelMapper.map(savedDirector, DirectorDTO.class);
	}

	@Override
	public void deleteDirector(Long id) {
		Optional<Director> optionalDirector = directorRepository.findById(id);
		if (optionalDirector.isPresent()) {
			directorRepository.delete(optionalDirector.get());
		} else {
			throw new IllegalArgumentException("Director not found");
		}
	}

	@Override
	public DirectorDTO updateDirector(Long id, Director director) {
		director.setId(id);
		Director updatedDirector = directorRepository.save(director);
		return modelMapper.map(updatedDirector, DirectorDTO.class);
	}

}
