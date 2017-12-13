package com.gmail.macieq44.motivateme.backend;

public class Role {
    public static final String USER = "user";

    private Role() {}

    public static String[] getRoles() {
        return new String[] {USER};
    }
}
