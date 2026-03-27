package com.adenilson.agendamento.repository;

import com.adenilson.agendamento.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Long> {
}
