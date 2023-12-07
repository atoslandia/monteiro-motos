package com.atosalves.dao.interfaceDAO;

public interface DAO<T, K> {
	void cadastrar(T entidade);

	T recuperarPeloId(K id);

	void deletePeloId(K id);

	T update(T entidade, K id);
}
