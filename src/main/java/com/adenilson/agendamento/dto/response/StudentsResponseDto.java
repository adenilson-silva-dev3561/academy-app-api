package com.adenilson.agendamento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class StudentsResponseDto {

    private Long Id;
    private String name;
    private String email;
    private LocalDate birth_date;
}
