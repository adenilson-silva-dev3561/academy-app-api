package com.adenilson.agendamento.service;

import java.util.Map;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.adenilson.agendamento.config.KeycloakProperties;
import com.adenilson.agendamento.dto.request.LoginRequest;
import com.adenilson.agendamento.dto.response.LoginResponse;

@Service
public class KeycloakService {

    private final KeycloakProperties keycloakProperties;
    private final RestTemplate restTemplate;

    public KeycloakService(KeycloakProperties keycloakProperties) {
        this.keycloakProperties = keycloakProperties;
        this.restTemplate = new RestTemplate();
    }

    public LoginResponse login(LoginRequest request) {

        String url = keycloakProperties.getServerUrl() + "/realms/" + keycloakProperties.getRealm()
                + "/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("client_id", keycloakProperties.getClientId());
        form.add("grant_type", "password");
        form.add("username", request.getUsername());
        form.add("password", request.getPassword());

        if (keycloakProperties.getClientSecret() != null
                && !keycloakProperties.getClientSecret().isBlank()) {
            form.add("client_secret", keycloakProperties.getClientSecret());
        }

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(form, headers);

        ResponseEntity<Map> response =
                restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

        Map body = response.getBody();

        LoginResponse loginResponse = new LoginResponse();

        loginResponse.setAcessToken((String) body.get("access_token"));
        loginResponse.setRefreshToken((String) body.get("refresh_token"));
        loginResponse.setTokenType((String) body.get("token_type"));
        loginResponse.setExpireIn((Integer) body.get("expires_in"));

        return loginResponse;

    }
}
