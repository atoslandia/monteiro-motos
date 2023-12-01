package com.atosalves.controller.exceptions;

public class UsuarioJaExisteException extends Exception{

    public UsuarioJaExisteException() {
        super("Usuario já existe ");
    }
}
