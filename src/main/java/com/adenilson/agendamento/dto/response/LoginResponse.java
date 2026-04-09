package com.adenilson.agendamento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String acessToken;
    private String refreshToken;
    private String tokenType;
    private Integer expireIn;
}
