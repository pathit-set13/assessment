package com.kbtg.bootcamp.posttest.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    List<UserAccount> userAccountList = new ArrayList<>();

    private final UserAccount userAccount;

    public UserService(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public UserAccount userAccessEndPoint() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserAccount user = new UserAccount(userAccount.getUsername(), encoder.encode(userAccount.getPassword()));
        user.setRoles(List.of(userAccount.roles.toString()));
        userAccountList.add(user);
        return user;
    }

    public UserAccount adminAccessEndPoint() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserAccount admin = new UserAccount(userAccount.getUsername(), encoder.encode(userAccount.getPassword()));
        admin.setRoles(List.of(userAccount.roles.toString()));
        userAccountList.add(admin);
        return admin;
    }

    public UserAccount findByUsername(String username) {
        return userAccountList
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));

    }

}
