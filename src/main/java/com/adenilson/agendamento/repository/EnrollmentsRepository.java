package com.adenilson.agendamento.repository;

import com.adenilson.agendamento.entity.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentsRepository extends JpaRepository<Enrollments, Long> {
    boolean existsByStudentId_IdAndCourseId_Id(Long studentId, Long courseId);
}

