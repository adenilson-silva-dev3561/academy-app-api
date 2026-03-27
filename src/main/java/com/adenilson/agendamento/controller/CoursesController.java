package com.adenilson.agendamento.controller;

import com.adenilson.agendamento.dto.request.CoursesRequestDto;
import com.adenilson.agendamento.dto.response.CoursesResponseDto;
import com.adenilson.agendamento.entity.Courses;
import com.adenilson.agendamento.service.CoursesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/academy")
public class CoursesController {

    private CoursesService coursesService;

    @PostMapping("/courses/create")
    public ResponseEntity<CoursesResponseDto> createCourses(@RequestBody CoursesRequestDto course){
        CoursesResponseDto newCourse = coursesService.createCourses(course);
        return  ResponseEntity.ok(newCourse);
    }

    @GetMapping
    public ResponseEntity<List<CoursesResponseDto>>getAllCourses(){
        List<CoursesResponseDto> courses = coursesService.getAllCourses();

        return ResponseEntity.ok(courses);
    }
}
