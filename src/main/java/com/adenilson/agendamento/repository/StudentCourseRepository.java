package com.adenilson.agendamento.repository;

import com.adenilson.agendamento.entity.Enrollments;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentCourseRepository extends JpaRepository<Enrollments, Long> {
    List<Enrollments> findAll();

    List<Enrollments> findByStudentId_Id(Long studentId);
}
