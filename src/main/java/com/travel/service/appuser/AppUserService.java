package com.travel.service.appuser;

import com.travel.model.User;
import com.travel.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements IAppUserService, UserDetailsService {
    @Autowired
    private AppUserRepo appUserRepo;

    @Override
    public User getUserByUserName(String username) {
        return appUserRepo.getLoginUserByUsername(username);
    }

    @Override
    public User getCurrentUser() {
        User user;
        String name;
        Object ob = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (ob instanceof UserDetails) {
            name = ((UserDetails) ob).getUsername();
        } else {
            name = ob.toString();
        }
        user = this.getUserByUserName(name);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getUserByUserName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) user.getRoles());
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
        return userDetails;
    }
}
