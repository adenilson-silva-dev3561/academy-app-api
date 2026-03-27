package com.adenilson.agendamento.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class StudentsRequestDto {

    private String name;
    private String email;
    private LocalDate birth_date;
}
