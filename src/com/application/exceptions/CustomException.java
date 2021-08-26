package com.application.exceptions;

// Checked (compile-time) -> Exception
// Unchecked (runtime) -> RuntimeException

public class CustomException extends Exception {

    public CustomException() {
        super("DEFAULT MESSAGE IS USED");
    }

    public CustomException(String message) {
        super(message);
    }

}
