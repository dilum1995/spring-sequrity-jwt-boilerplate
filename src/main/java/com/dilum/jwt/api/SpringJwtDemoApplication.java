package com.dilum.jwt.api;

import com.dilum.jwt.api.entity.User;
import com.dilum.jwt.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringJwtDemoApplication {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJwtDemoApplication.class, args);
    }

    @PostConstruct
    public void intiUsers() {
        List<User> users = Stream.of(
                new User(101, "user1", "password1", "email1@gmail.com"),
                new User(102, "user2", "password2", "email2@gmail.com"),
                new User(103, "user3", "password3", "email3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

}
