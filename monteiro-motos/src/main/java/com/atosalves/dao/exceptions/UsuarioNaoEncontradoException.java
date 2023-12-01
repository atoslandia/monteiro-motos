package com.atosalves.dao.exceptions;

public class UsuarioNaoEncontradoException extends Exception{
    public UsuarioNaoEncontradoException() {
        super("Usuario não encontrado");
    }

}
