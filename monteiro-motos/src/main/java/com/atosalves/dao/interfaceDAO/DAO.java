package com.atosalves.dao.interfaceDAO;

import com.atosalves.dao.exceptions.UsuarioNaoEncontradoException;

public interface DAO<T, K> {


	public void cadastrar(T entidade);

	public T recuperarPeloId(K id);

	public void deletePeloId(K id);
}
