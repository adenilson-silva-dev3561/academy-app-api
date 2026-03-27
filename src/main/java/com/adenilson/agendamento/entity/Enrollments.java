package com.adenilson.agendamento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "enrollments", schema = "academy",
uniqueConstraints = @UniqueConstraint(columnNames = {"course_id","student_id"} ))
public class Enrollments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate enrollment_date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Students studentId ;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses courseId;



}

