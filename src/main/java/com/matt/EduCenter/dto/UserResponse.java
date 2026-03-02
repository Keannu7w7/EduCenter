package com.matt.EduCenter.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String rol;
}