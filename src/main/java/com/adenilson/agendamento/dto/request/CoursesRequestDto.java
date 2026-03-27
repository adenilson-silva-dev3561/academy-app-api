package com.adenilson.agendamento.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CoursesRequestDto {
    private String name;
    private  String description;
    private String image_url;
    private Long workload;
}
