package com.adenilson.agendamento.service;

import com.adenilson.agendamento.dto.request.CoursesRequestDto;
import com.adenilson.agendamento.dto.response.CoursesResponseDto;
import com.adenilson.agendamento.entity.Courses;
import com.adenilson.agendamento.repository.CoursesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CoursesService {

    private CoursesRepository coursesRepository;

    public CoursesResponseDto createCourses(CoursesRequestDto dto){
        Courses courses = new Courses();
        courses.setName(dto.getName());
        courses.setDescription(dto.getDescription());
        courses.setImage_url(dto.getImage_url());
        courses.setWorkload(dto.getWorkload());

        return  toDto(coursesRepository.save(courses));
    }

    public List<CoursesResponseDto> getAllCourses(){
        List<CoursesResponseDto> courses = coursesRepository.findAll().stream().map(this::toDto).toList();

        return courses;
    }
    private CoursesResponseDto toDto(Courses courses){
        return new CoursesResponseDto(
                courses.getId(),
                courses.getName(),
                courses.getDescription(),
                courses.getImage_url(),
                courses.getWorkload()
        );
    }
}
