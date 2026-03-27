package com.adenilson.agendamento.service;

import com.adenilson.agendamento.dto.response.StudentCourseResponseDto;

import com.adenilson.agendamento.entity.Enrollments;
import com.adenilson.agendamento.repository.StudentCourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentCourseService {

    private final StudentCourseRepository studentCourseRepository;

    public List<StudentCourseResponseDto> lisCourseStudents() {

        return studentCourseRepository.findAll().stream().map(this::toDto).toList();

    }

    // entrada = pegar o id do aluno
    // Buscar das matriculas enrollments o StudentId
    // retornar o Studande e su curso, como retona no toDto

    public List<StudentCourseResponseDto> getCoursesByStudent(Long StudentId) {

        List<Enrollments> enrollments = studentCourseRepository.findByStudentId_Id(StudentId);

        return enrollments.stream().map(this::toDto).toList();

    }

    private StudentCourseResponseDto toDto(Enrollments dto) {
        return new StudentCourseResponseDto(dto.getStudentId().getId(),
                dto.getStudentId().getName(), dto.getCourseId().getId(), dto.getCourseId().getName()

        );
    }

}
