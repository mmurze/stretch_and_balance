package com.example.web_app.repository;

import com.example.web_app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    Boolean existsByUsername(String username);

    Optional<UserEntity> findByResetToken(String resetToken);

    Optional<UserEntity> findByUsername(String username);
}
