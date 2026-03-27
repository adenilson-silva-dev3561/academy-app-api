package com.adenilson.agendamento.service;

import com.adenilson.agendamento.dto.request.StudentsRequestDto;
import com.adenilson.agendamento.dto.response.StudentsResponseDto;
import com.adenilson.agendamento.entity.Students;
import com.adenilson.agendamento.repository.StudentsRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;


import java.time.LocalDate;

@Service
@AllArgsConstructor
public class StudentsService {

    private final StudentsRepository studentsRepository;

    public StudentsResponseDto createStudents(StudentsRequestDto dto){
        Students newStudent = new Students();

        newStudent.setName(dto.getName());
        newStudent.setEmail(dto.getEmail());
        newStudent.setBirth_date(LocalDate.now());

        return toDto(studentsRepository.save(newStudent));
    }

    public StudentsResponseDto updateStudents( Long id, StudentsRequestDto dto ){
        Students student = studentsRepository.findById(id).orElseThrow(()-> new RuntimeException("erro ao atualizar estudante"));
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setBirth_date(dto.getBirth_date());

        Students studentUpdated = studentsRepository.save(student);

        return  toDto(studentUpdated);

    }


    private StudentsResponseDto toDto(Students student){
        return new StudentsResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getBirth_date()
        );
    }


}
