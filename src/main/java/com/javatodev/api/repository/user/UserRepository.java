package com.javatodev.api.repository.user;

import com.javatodev.api.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
