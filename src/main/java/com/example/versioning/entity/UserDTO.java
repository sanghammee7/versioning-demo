package com.example.versioning.entity;


import org.springframework.stereotype.Component;


public record UserDTO(Integer id, String  name, String email, String website) {
}
