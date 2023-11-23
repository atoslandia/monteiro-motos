package com.atosalves.dao;

import com.atosalves.model.Corrida;

import java.util.ArrayList;
import java.util.List;

public class CorridaDAO implements DAO<Corrida, Long>, BuscaCorridasDAO {

	private ArrayList<Corrida> corridas = new ArrayList<>();


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
	public void deletePeloId(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public List<Corrida> buscarCorridasPendenetes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'buscarCorridasPendenetes'");
	}

	@Override
	public List<Corrida> buscarCorridasEmAndamento() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'buscarCorridasEmandamento'");
	}

	@Override
	public List<Corrida> buscarCorridasCanceladas() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'buscarCorridasCanceladas'");
	}

	@Override
	public List<Corrida> buscarCorridasReivindicadas() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'buscarCorridasReivindicadas'");
	}
}
