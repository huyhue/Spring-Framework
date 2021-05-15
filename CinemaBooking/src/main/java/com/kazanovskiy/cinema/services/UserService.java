package com.kazanovskiy.cinema.services;

import com.kazanovskiy.cinema.model.Users;

import java.util.List;

public interface UserService {

    List<Users> findAll();

    Users findByUsername(String userName);

    Users findByEmail(String email);

    Users findByPhone(String telephone);

    Users findById(Long id);

    void delete(Long id);

    void update(Users users);

    void add(Users users);
}
