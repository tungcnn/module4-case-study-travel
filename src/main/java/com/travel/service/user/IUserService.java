package com.travel.service.user;

import com.travel.model.User;
import com.travel.service.IGeneral;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneral<User>, UserDetailsService {
    Iterable<User> findAll();
    User findByUsername(String username);
    Optional<User> findById(Long id);
}
