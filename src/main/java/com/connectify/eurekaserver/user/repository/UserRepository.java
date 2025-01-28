package com.connectify.eurekaserver.user.repository;

import com.connectify.eurekaserver.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}