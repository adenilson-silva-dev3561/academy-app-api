package com.adenilson.agendamento.repository;

import com.adenilson.agendamento.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository <Courses, Long> {

}
