package com.wentao.hmsmanager.config.security;

import com.wentao.hmsmanager.entity.HmsPermission;
import com.wentao.hmsmanager.entity.HmsRole;
import com.wentao.hmsmanager.entity.HmsUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class HmsUserDetails implements UserDetails {

    private HmsUser currentUser;
    private List<SimpleGrantedAuthority> authorities;

    public HmsUserDetails(HmsUser currentUser) {
        this.currentUser = currentUser;
        HmsRole role = currentUser.getRole();
        authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUser.getPassword();
    }

    @Override
    public String getUsername() {
        return currentUser.getUsername();
    }

    public HmsUser getCurrentUser() {
        return currentUser;
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
