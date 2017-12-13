package com.gmail.macieq44.motivateme.backend;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException() {
        super();
    }

    public UserAlreadyExistException(final String message) {
        super(message);
    }
}
