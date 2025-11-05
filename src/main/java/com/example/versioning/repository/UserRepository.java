package com.example.versioning.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import com.example.versioning.entity.User;
import java.util.List;
import java.util.ArrayList;
@Repository
public class UserRepository {
    private final List<User> users= new ArrayList<>();

    public List<User> findAll(){
        return users;
    }

    public User findById(Integer id){
        return users.stream().filter(u->u.id().equals(id)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init(){
        users.add(new User(1,"Sanghammee", "sanghammee.oval@gmail.com", "www.google.com"));
    }
}

