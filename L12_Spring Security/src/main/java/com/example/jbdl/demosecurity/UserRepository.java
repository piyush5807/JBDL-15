package com.example.jbdl.demosecurity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String username);
}
