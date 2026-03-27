package com.adenilson.agendamento.controller;

import com.adenilson.agendamento.dto.request.StudentsRequestDto;
import com.adenilson.agendamento.dto.response.StudentsResponseDto;
import com.adenilson.agendamento.service.StudentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/academy")
public class StudentsController {

    private final StudentsService studentsService;

    @PostMapping("/students/create")
    public ResponseEntity<StudentsResponseDto> createStudent(@RequestBody StudentsRequestDto student){
        StudentsResponseDto newStudent = studentsService.createStudents(student);

        return ResponseEntity.ok(newStudent);

    }

    @PutMapping("/students/update/{id}")
    public ResponseEntity<StudentsResponseDto> studentUpdate(@PathVariable Long id, @RequestBody StudentsRequestDto student){
        StudentsResponseDto studentUpdated = studentsService.updateStudents(id, student );

        return ResponseEntity.ok(studentUpdated);
    }

}
