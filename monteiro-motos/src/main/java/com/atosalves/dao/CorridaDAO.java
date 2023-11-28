package com.atosalves.dao;

import com.atosalves.dao.interfaceDAO.BuscaCorridasDAO;
import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.db.Persistencia;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.PassageiroBoletoDTO;
import com.atosalves.model.Corrida;
import com.atosalves.model.facadepattern.MensageiroFacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CorridaDAO implements DAO<CorridaDTO, Long>, BuscaCorridasDAO {

	private Map<String, ArrayList<Corrida>> corridas;
	private Persistencia persistencia;

	public CorridaDAO() {
		persistencia = Persistencia.getInstance();
		corridas = persistencia.carregarCorridas();
		
	}

	@Override
	public boolean cadastrar(CorridaDTO entidade) {
		try {
			Corrida corrida = entidade.corrida();
			corridas.get("pendente".toUpperCase()).add(corrida);
			persistencia.salvarCorridas(corridas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public CorridaDTO recuperarPeloId(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'recuperarPeloId'");
	}

	@Override
	public void deletePeloId(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}

	@Override
	public List<Corrida> buscarCorridasPendenetes() {
		return corridas.get("pendente".toUpperCase());
	}

	@Override
	public List<Corrida> buscarCorridasEmAndamento() {
		return corridas.get("em andamento".toUpperCase());
	}

	@Override
	public List<Corrida> buscarCorridasCanceladas() {
		return corridas.get("canceladas".toUpperCase());
	}

	@Override
	public List<Corrida> buscarCorridasReivindicadas() {
		return corridas.get("reivindicadas".toUpperCase());
	}


	public static void main(String[] args) {
		Corrida c = new Corrida();
		CorridaDTO cdto = new CorridaDTO(c);
		CorridaDAO corridaDAO = new CorridaDAO();
		corridaDAO.cadastrar(cdto);
		corridaDAO.buscarCorridasPendenetes().forEach(System.out::println);
	}


}
