package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.LoginRequestDTO;
import com.pedro.ordermanager.dto.RegisterUserDTO;
import com.pedro.ordermanager.dto.ResponseLoginDTO;
import com.pedro.ordermanager.infrastructure.security.TokenService;
import com.pedro.ordermanager.model.User;
import com.pedro.ordermanager.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")

public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequestDTO body){
        User user = this.userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("Usuario não encontrado -> Controller"));

        if(passwordEncoder.matches(user.getPassword(), body.password())){
            var token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseLoginDTO(user.getEmail(),token));
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterUserDTO body){
        var user = this.userRepository.findByEmail(body.email());

        if(user.isEmpty()){
            User newUser = new User();
            newUser.setEmail(body.email());
            newUser.setPassword(passwordEncoder.encode(body.password()));
            this.userRepository.save(newUser);
            var token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseLoginDTO(newUser.getEmail(),token));
        }

        return ResponseEntity.badRequest().build();
    }
}
