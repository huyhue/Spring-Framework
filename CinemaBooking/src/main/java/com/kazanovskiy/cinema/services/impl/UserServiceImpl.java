package com.kazanovskiy.cinema.services.impl;

import com.kazanovskiy.cinema.model.Users;
import com.kazanovskiy.cinema.repository.TicketRepository;
import com.kazanovskiy.cinema.repository.UserRepository;
import com.kazanovskiy.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final TicketRepository ticketRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TicketRepository ticketRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Users findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    public Users findById(Long id) {
        return userRepository.findOne(id);
    }

    public void delete(Long id) {
        userRepository.delete(id);

    }

    public void update(Users users) {
        userRepository.saveAndFlush(users);
    }

    public void add(Users users) {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        userRepository.save(users);
    }

}

