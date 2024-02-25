package com.kbtg.bootcamp.posttest.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN)")
    @GetMapping("/users")
    public String greetingUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Welcome User.";
    }

}
