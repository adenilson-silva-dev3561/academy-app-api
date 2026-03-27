package com.adenilson.agendamento.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "courses", schema = "academy")
@Data
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String image_url;
    private Long workload;
}
