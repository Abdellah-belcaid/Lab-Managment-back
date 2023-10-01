package com.labmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.*;

import com.labmanagement.model.entity.User;
import com.labmanagement.service.IUserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final IUserService userService;

    @PostMapping("/sign-in")
    public ResponseEntity<Object> login(@RequestBody User userLoginDTO) {
        try {
            Object user = userService.login(userLoginDTO);
            return ResponseEntity.ok(user);
        } catch (DisabledException e) {
            // Customize the response for disabled accounts
            String errorMessage = "Account is disabled. Please contact support for assistance.";
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
        } catch (Exception e) {
            // Return INTERNAL SERVER ERROR (500) with a generic error message
            String errorMessage = "An error occurred during login ";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage + " : " + e.getMessage());

        }
    }

    @PostMapping("/sign-up")
    public ResponseEntity<Object> register(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.register(user)); // Return OK (200) with the registered user object
        } catch (Exception e) {
            String errorMessage = "An error occurred while registering.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage + " : " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<String> verifyUserAccount(@RequestParam("token") String token) {
        try {
            Boolean isSuccess = userService.verifyToken(token);

            if (isSuccess) {
                return ResponseEntity.ok("Account has been verified successfully.");
            } else {
                throw new RuntimeException("Account has not been confirmed.");
            }
        } catch (Exception e) {
            String errorMessage = "An error occurred while verifying the account.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage + " : " + e.getMessage());
        }
    }
}