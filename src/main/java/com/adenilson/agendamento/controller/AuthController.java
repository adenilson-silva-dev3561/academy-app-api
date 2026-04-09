package com.adenilson.agendamento.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.adenilson.agendamento.dto.request.LoginRequest;
import com.adenilson.agendamento.dto.response.LoginResponse;
import com.adenilson.agendamento.service.KeycloakService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/academy-app")
public class AuthController {

    private final KeycloakService keycloakService;

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        LoginResponse login = keycloakService.login(request);

        return ResponseEntity.ok(login);
    }
}
