package com.pedro.ordermanager.controller;

import com.pedro.ordermanager.dto.DataAuthentication;
import com.pedro.ordermanager.dto.DataTokenJWT;
import com.pedro.ordermanager.infrastructure.security.TokenService;
import com.pedro.ordermanager.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity authenticateUser(@RequestBody @Valid DataAuthentication data){
        var token = new UsernamePasswordAuthenticationToken(data.username(),data.password());
        var authentication = manager.authenticate(token);
        System.out.println(authentication);
        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }
}
