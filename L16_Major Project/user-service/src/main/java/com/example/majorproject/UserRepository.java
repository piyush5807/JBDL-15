package com.example.majorproject;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    // Query is not needed
    User findByUserId(String userId);

}
