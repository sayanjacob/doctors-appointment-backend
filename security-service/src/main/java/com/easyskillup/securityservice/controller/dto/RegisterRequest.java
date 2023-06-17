package com.easyskillup.securityservice.controller.dto;

public record RegisterRequest(String firstName, String lastName, String email, String password, String role) {
}
