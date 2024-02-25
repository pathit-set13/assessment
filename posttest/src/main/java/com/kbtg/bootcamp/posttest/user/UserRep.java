package com.kbtg.bootcamp.posttest.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRep {

//    Todo: Should be Data Base

    List<UserAccount> userDetails = new ArrayList<>();

    public UserRep() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserAccount user = new UserAccount("member", encoder.encode("password"));
        user.setRoles(List.of("MEMBER"));
        user.setPermissions(List.of("MEMBER_READ"));
        userDetails.add(user);

        UserAccount admin = new UserAccount("admin", encoder.encode("password"));
        admin.setRoles(List.of("ADMIN"));
        userDetails.add(admin);
    }

    public UserAccount findUserByUsername(String username) {
        return userDetails
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
    }
}
