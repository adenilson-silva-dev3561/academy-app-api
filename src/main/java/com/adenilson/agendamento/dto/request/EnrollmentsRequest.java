package com.adenilson.agendamento.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EnrollmentsRequest {

    private Long studentId;
    private Long courseId;
}
