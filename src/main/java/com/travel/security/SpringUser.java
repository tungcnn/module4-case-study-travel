package com.travel.security;

import com.travel.model.AppUser;
import org.springframework.security.core.authority.AuthorityUtils;


public class SpringUser extends org.springframework.security.core.userdetails.User {
    private AppUser user;

    public SpringUser(AppUser user){
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("user"));
        this.user = user;
    }

    public AppUser getUser(){
        return user;
    }
}
