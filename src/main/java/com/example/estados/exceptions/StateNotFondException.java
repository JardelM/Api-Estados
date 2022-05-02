package com.example.estados.exceptions;

import static java.lang.String.format;

public class StateNotFondException extends RuntimeException{
    public StateNotFondException(Long id) {
        super(format("Não há registro de Estado com id %s", id));
    }
}
