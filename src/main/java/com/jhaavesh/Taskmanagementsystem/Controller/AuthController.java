package com.jhaavesh.Taskmanagementsystem.Controller;

import com.jhaavesh.Taskmanagementsystem.Controller.Dto.LoginRequest;
import com.jhaavesh.Taskmanagementsystem.Controller.Dto.LoginResponse;
import com.jhaavesh.Taskmanagementsystem.Model.User;
import com.jhaavesh.Taskmanagementsystem.Security.JwtUtil;
import com.jhaavesh.Taskmanagementsystem.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            // Encrypt password before saving
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            User savedUser = userService.saveUser(user);

            // Remove password from response
            savedUser.setPassword(null);

            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Registration failed: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            User user = userService.getUserByEmail(loginRequest.getEmail());

            if (user == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            // Verify password
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                return new ResponseEntity<>("Invalid password", HttpStatus.UNAUTHORIZED);
            }

            // Generate JWT token
            String token = jwtUtil.generateToken(user.getEmail(), user.getId());

            LoginResponse response = new LoginResponse(
                    token,
                    "Login successful",
                    user.getId(),
                    user.getEmail(),
                    user.getName()
            );

            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Login failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}