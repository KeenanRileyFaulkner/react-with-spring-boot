package com.keena.reactwithspringboot.exception;

public class JokeNotFoundException extends RuntimeException {
    public JokeNotFoundException(Long id) {
        super("Could not get joke " + id + " [get it ;)-]");
    }
}
