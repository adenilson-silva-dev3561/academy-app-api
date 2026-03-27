package com.adenilson.agendamento.controller;


import com.adenilson.agendamento.dto.response.StudentCourseResponseDto;
import com.adenilson.agendamento.service.StudentCourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/academy")
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @GetMapping("/students-courses")
    public ResponseEntity<List<StudentCourseResponseDto>> allStudentCourse() {

        List<StudentCourseResponseDto> listStudentCourse = studentCourseService.lisCourseStudents();

        return ResponseEntity.ok(listStudentCourse);
    }

    @GetMapping("/students-courses/{id}")
    public ResponseEntity<List<StudentCourseResponseDto>> getStudentCourse(@PathVariable Long id) {

        List<StudentCourseResponseDto> studentCourse = studentCourseService.getCoursesByStudent(id);

        return ResponseEntity.ok(studentCourse);
    }
}
