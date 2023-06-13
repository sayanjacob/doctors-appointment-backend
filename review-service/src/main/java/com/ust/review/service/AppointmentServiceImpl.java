package com.ust.review.service;

import com.ust.review.domain.Appointment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    RestTemplate restTemplate;
    public AppointmentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<Appointment> findAppointmentByDocIdAndUsId(Long userId,Long doctorId) {
        var response = restTemplate.getForEntity("http://localhost:8200/appointment/find/{userId}/{doctorId}",
                Appointment[].class,userId,doctorId);

        return Arrays.stream(response.getBody()).findFirst();

    }
}
