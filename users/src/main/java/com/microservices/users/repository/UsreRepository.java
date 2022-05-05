package com.microservices.users.repository;

import com.microservices.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsreRepository extends JpaRepository<User,Integer> {
}
