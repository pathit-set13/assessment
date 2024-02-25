package com.kbtg.bootcamp.posttest.user;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Table(name = "user_account")
public class UserAccount implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "user_role")
    Set<String> roles = new HashSet<>();

    Set<String> permissions = new HashSet<>();

    @Column(name = "user_name")
    private final String username;

    @Column(name = "user_password")
    private final String password;

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setRoles(List<String> roles) {
        this.roles.addAll(roles);
    }

    public void setPermissions(List<String> permissions) {
        this.permissions.addAll(permissions);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for(String role: roles) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_" + role));
        }

        for (String permission: permissions) {
            authorityList.add(new SimpleGrantedAuthority(permission));
        }

        return authorityList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
