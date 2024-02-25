package com.kbtg.bootcamp.posttest.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserService {

//    @PersistenceContext
//    private EntityManager entityManager;

    List<UserAccount> userAccountList = new ArrayList<>();

    public UserAccount findByUsername(String username) {
//        // Fetch user details from the database based on the username
//        List<UserAccount> result = entityManager.createQuery(
//                        "SELECT u FROM UserAccount u WHERE u.username = :username", UserAccount.class)
//                .setParameter("username", username)
//                .getResultList();
//
//        if (!result.isEmpty()) {
//            return result.get(0);
//        } else {
//            throw new UsernameNotFoundException("No user was found");
//        }
        return userAccountList
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));

    }
}
