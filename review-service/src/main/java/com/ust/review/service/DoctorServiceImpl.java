package com.ust.review.service;

import com.ust.review.domain.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        //if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();

    }
}



