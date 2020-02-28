package com.dinexpod.manik;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    USER, ADMIN, MASTER, CLIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
