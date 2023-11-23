package com.atosalves.dao;


public interface DAO<T, K> {

	public boolean cadastrar(T entidade);

	public T recuperarPeloId(K id);

	public T update(T entidade);

	public void delete();
}
