package com.atosalves.dao;

import java.util.Set;

public interface DAO<T, K> {
	public Set<T> recuperarTodos();

	public boolean cadastrar(T entidade);

	public T recuperarPeloId(K id);

	public T update(T entidade);

	public void delete();
}
