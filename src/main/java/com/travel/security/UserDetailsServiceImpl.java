package com.travel.security;

import com.travel.model.AppUser;
import com.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser byUsername = userRepository.findByUsername(username);
        if (byUsername == null){
            throw new UsernameNotFoundException("User with does not exist");
        }
        return new SpringUser(byUsername);
    }
}
