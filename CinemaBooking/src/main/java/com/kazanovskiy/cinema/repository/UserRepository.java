package com.kazanovskiy.cinema.repository;

import com.kazanovskiy.cinema.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByUsername(String userName);

    Users findByEmail(String email);

    Users findByPhone(String phone);
}

