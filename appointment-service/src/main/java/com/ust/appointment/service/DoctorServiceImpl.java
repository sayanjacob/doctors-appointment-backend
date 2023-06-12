package com.ust.appointment.service;

import com.ust.appointment.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {
    RestTemplate restTemplate;

    public DoctorServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Doctor findById(long doctorId) {
        var response = restTemplate.getForEntity("http://localhost:8000/admin/find/{doctorId}",
                Doctor.class, doctorId);
        return response.getBody();
    }
}



