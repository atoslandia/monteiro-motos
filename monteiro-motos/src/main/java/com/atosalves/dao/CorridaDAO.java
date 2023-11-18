package com.atosalves.dao;

import com.atosalves.model.Corrida;
import java.util.HashSet;
import java.util.Set;

public class CorridaDAO implements DAO<Corrida, Long> {

	private Set<Corrida> corridas = new HashSet<>();

	@Override
	public Set<Corrida> recuperarTodos() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'recuperarTodos'");
	}

	@Override
	public boolean cadastrar(Corrida entidade) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'cadastrar'");
	}

	@Override
	public Corrida recuperarPeloId(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'recuperarPeloId'");
	}

	@Override
	public Corrida update(Corrida entidade) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}
