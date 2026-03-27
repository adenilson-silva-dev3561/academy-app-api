package com.adenilson.agendamento.dto.response;

import com.adenilson.agendamento.entity.Courses;
import com.adenilson.agendamento.entity.Students;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Data
public class EnrollmentsResponse {

    private Long studentId;
    private Long courseId;
    private LocalDate enrollmentDate;

}
