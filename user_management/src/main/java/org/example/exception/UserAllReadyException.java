package org.example.exception;

public class UserAllReadyException extends RuntimeException {
    public UserAllReadyException(String message) {
        super(message);
    }
}
