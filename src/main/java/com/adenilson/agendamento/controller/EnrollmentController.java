package com.adenilson.agendamento.controller;

import com.adenilson.agendamento.dto.request.EnrollmentsRequest;
import com.adenilson.agendamento.dto.response.EnrollmentsResponse;
import com.adenilson.agendamento.service.CoursesService;
import com.adenilson.agendamento.service.EnrollmentsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/academy")
public class EnrollmentController {

    private final EnrollmentsService enrollmentsService;
    @PostMapping("/enrollment")
    public ResponseEntity<EnrollmentsResponse> enrollmentStudent(@RequestBody EnrollmentsRequest enrollment){
        EnrollmentsResponse newEnrollments = enrollmentsService.enrollStudent(enrollment);

        return  ResponseEntity.ok(newEnrollments);
    }
}
