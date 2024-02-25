package com.kbtg.bootcamp.posttest.service;

import com.kbtg.bootcamp.posttest.user.UserRep;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenUserDetailService implements UserDetailsService {


    private final UserRep userRep;

    public AuthenUserDetailService(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRep.findUserByUsername(username);
    }
}
