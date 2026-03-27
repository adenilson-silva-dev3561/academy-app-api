package com.adenilson.agendamento.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoursesResponseDto {
    private Long id;
    private String name;
    private String description;
    private String image_url;
    private Long workload;
}
