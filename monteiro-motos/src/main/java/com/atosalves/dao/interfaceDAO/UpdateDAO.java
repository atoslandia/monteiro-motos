package com.atosalves.dao.interfaceDAO;

import com.atosalves.dao.exceptions.UsuarioNaoEncontradoException;

public interface UpdateDAO<U,K> {
    
    public U update(U entidade, K id) throws UsuarioNaoEncontradoException;
}
