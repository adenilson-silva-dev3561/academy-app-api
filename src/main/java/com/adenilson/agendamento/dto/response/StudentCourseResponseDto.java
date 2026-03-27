package com.adenilson.agendamento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentCourseResponseDto {
    private Long sudentId;
    private String studentName;
    private Long courseId;
    private String courseName;
}
