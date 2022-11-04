package com.criminaldetector.criminadector.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public abstract class AbstractDetails implements UserDetails{

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }

    public abstract String getPassword();

    public abstract String getBadge();

    @Override
    public boolean isAccountNonExpired(){
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

    public abstract String getName();
    public abstract String getSex();
    public abstract Long getAge();
    public abstract String getRole();
    public abstract Long getId();
    
}
