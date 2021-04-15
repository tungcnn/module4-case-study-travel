package com.travel.service.user;

import com.travel.model.User;
import com.travel.service.IGeneral;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneral<User>, UserDetailsService {
    User findByUsername(String username);
}
