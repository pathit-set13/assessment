package com.kbtg.bootcamp.posttest.repository;

import com.kbtg.bootcamp.posttest.security.CustomUserDetail;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

//    Todo: Should be Data Base

    List<CustomUserDetail> userDetails = new ArrayList<>();

    public UserRepository() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        CustomUserDetail user = new CustomUserDetail("member", encoder.encode("password"));
        user.setRoles(List.of("MEMBER"));
        user.setPermissions(List.of("MEMBER_READ"));
        userDetails.add(user);

        CustomUserDetail admin = new CustomUserDetail("admin", encoder.encode("password"));
        admin.setRoles(List.of("ADMIN"));
        userDetails.add(admin);
    }

    public CustomUserDetail findUserByUsername(String username) {
        return userDetails
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
    }
}
