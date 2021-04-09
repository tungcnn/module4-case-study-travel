package com.travel.service.user;

import com.travel.model.AppUser;
import com.travel.service.IGeneral;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneral<AppUser>, UserDetailsService {
    AppUser getUserByUsername(String username);
    AppUser getCurrentUser();
}
