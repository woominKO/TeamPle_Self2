package com.example.TeamPle_Self2.repository;

import com.example.TeamPle_Self2.domain.Room;
import com.example.TeamPle_Self2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
