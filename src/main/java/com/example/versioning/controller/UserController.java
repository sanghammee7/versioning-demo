package com.example.versioning.controller;


import com.example.versioning.entity.User;
import com.example.versioning.entity.UserDTO;
import com.example.versioning.entity.UserDTOV2;
import com.example.versioning.entity.UserMapper;
import com.example.versioning.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserController(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @GetMapping(value = "/{version}/users", version = "1.0")
    public List<UserDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::tov1)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/users", version = "1.1")
    public List<UserDTO> getUserV1(){
        return repository.findAll()
                .stream()
                .map(mapper::tov1)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{version}/users", version = "2.0")
    public List<UserDTOV2> findAllV2(){
        return repository.findAll()
                .stream()
                .map(mapper::tov2)
                .collect(Collectors.toList());
    }


}

