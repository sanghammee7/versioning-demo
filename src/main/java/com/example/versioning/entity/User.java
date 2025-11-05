package com.example.versioning.entity;

import org.springframework.stereotype.Component;


public record User(Integer id, String name, String email, String website) {
}

