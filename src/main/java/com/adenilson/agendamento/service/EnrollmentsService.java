package com.adenilson.agendamento.service;

import com.adenilson.agendamento.dto.request.EnrollmentsRequest;
import com.adenilson.agendamento.dto.response.EnrollmentsResponse;
import com.adenilson.agendamento.entity.Courses;
import com.adenilson.agendamento.entity.Enrollments;
import com.adenilson.agendamento.entity.Students;
import com.adenilson.agendamento.repository.CoursesRepository;
import com.adenilson.agendamento.repository.EnrollmentsRepository;
import com.adenilson.agendamento.repository.StudentsRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.time.LocalDate;

@Service
@AllArgsConstructor
@Getter
@Setter
public class EnrollmentsService {

    private final EnrollmentsRepository enrollmentsRepository;
    private final StudentsRepository studentsRepository;
    private final CoursesRepository coursesRepository;


    public EnrollmentsResponse enrollStudent(EnrollmentsRequest dto) {


        boolean alreadExist = enrollmentsRepository
                .existsByStudentId_IdAndCourseId_Id(dto.getStudentId(), dto.getCourseId());

        if (alreadExist) {
            throw new RuntimeException("Estudante já cadastrado nesse curso");
        }
        Students student = studentsRepository.getReferenceById(dto.getStudentId());
        Courses course = coursesRepository.getReferenceById(dto.getCourseId());

        Enrollments newEnrollments = new Enrollments();

        newEnrollments.setStudentId(student);
        newEnrollments.setCourseId(course);
        newEnrollments.setEnrollment_date(LocalDate.now());

        return toDto(enrollmentsRepository.save(newEnrollments));


    }

    private EnrollmentsResponse toDto(Enrollments dto) {

        return new EnrollmentsResponse(dto.getStudentId().getId(), dto.getCourseId().getId(),
                dto.getEnrollment_date());
    }
}

