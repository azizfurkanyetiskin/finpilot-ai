package com.azizfurkan.finpilotai.repository;

import com.azizfurkan.finpilotai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
