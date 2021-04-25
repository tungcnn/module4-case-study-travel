package com.travel.repository;

import com.travel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<User, Long> {
    User getLoginUserByUsername(String username);
}
