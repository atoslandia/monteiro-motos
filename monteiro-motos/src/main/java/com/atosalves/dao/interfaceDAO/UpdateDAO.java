package com.atosalves.dao.interfaceDAO;

import com.atosalves.dao.exceptions.UsuarioNaoEncontradoException;

public interface UpdateDAO<U,T,K> {
    
    public U update(T entidade, K id) throws UsuarioNaoEncontradoException;
}
