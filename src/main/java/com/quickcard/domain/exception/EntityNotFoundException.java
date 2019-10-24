package com.quickcard.domain.exception;


public class EntityNotFoundException extends Exception {

    public EntityNotFoundException() { super("A entidade não foi localizada na base"); }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public  EntityNotFoundException(Throwable cause) { super(cause);}
}
