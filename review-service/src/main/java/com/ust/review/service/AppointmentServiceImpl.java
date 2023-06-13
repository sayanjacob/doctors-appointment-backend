package com.ust.review.service;

import com.ust.review.domain.Appointment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    RestTemplate restTemplate;
    public AppointmentServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Appointment> findAppointmentByDocIdAndUsId(Long doctorId,Long userId) {
        var response = restTemplate.getForEntity("http://localhost:8200/appointment/find/{doctorId}/{userId}",
                Appointment[].class, doctorId,userId);
        if (response.hasBody()) {
            return Arrays.stream(response.getBody()).toList();
        }
        return List.of();

    }
}
