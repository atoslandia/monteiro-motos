package com.atosalves.dao;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dao.interfaceDAO.BuscaCorridasDAO;
import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.db.Persistencia;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.model.Corrida;
import java.util.ArrayList;
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
	public void cadastrar(CorridaDTO entidade) {
		Corrida corrida = entidade.corrida();
		corridas.get(entidade.corrida().getEstado().getNome()).add(corrida);
		persistencia.salvarCorridas(corridas);
	}

	@Override
	public CorridaDTO recuperarPeloId(Long id) {
		for (ArrayList<Corrida> c : corridas.values()) {
			for (Corrida corrida : c) {
				if (corrida.getId().equals(id)) {
					CorridaDTO corridaDTO = new CorridaDTO(corrida);
					return corridaDTO;
				}
			}
		}
		return null;
	}

	@Override
	public void deletePeloId(Long id) {
		try {
			CorridaDTO corridaDTO = recuperarPeloId(id);
			corridas.get(corridaDTO.corrida().getEstado().getNome()).remove(corridaDTO.corrida());

			persistencia.salvarCorridas(corridas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Corrida> buscarCorridasPendenetes() {
		return corridas.get("pendente".toUpperCase());
	}

	@Override
	public List<Corrida> buscarCorridasEmAndamento() {
		return corridas.get("reivindicada".toUpperCase());
	}

	@Override
	public List<Corrida> buscarCorridasCanceladas() {
		return corridas.get("cancelada".toUpperCase());
	}

	@Override
	public List<Corrida> buscarCorridasFinalizadas() {
		return corridas.get("finalizada".toUpperCase());
	}

	@Override
	public void moverCorrida(CorridaEventoDTO evento) {
		Corrida corrida = recuperarPeloId(evento.corrida().getId()).corrida();
		corridas.get(evento.estadoAntigo()).remove(corrida);
		corridas.get(evento.corrida().getEstado().getNome()).add(corrida);
		try {
			persistencia.salvarCorridas(corridas);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CorridaDTO update(CorridaDTO entidade) {
		Corrida corrida = recuperarPeloId(entidade.corrida().getId()).corrida();
		corrida = entidade.corrida();
		try {
			persistencia.salvarCorridas(corridas);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new CorridaDTO(corrida);
	}
	// public static void main(String[] args) {
	// 	GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
	// 	Passageiro p = new Passageiro("Robson", null, null, null);
	// 	Mototaxista m = new Mototaxista("Atos", null, null, null);
	// 	gerenciadorDeCorrida.solicitarCorrida(p, null, null);
	// 	gerenciadorDeCorrida.reivindicarCorrida(m);
	// 	gerenciadorDeCorrida.solicitarCorrida(p, null, null);
	// 	gerenciadorDeCorrida.cancelarCorrida();
	// 	gerenciadorDeCorrida.solicitarCorrida(p, null, null);
	// 	// gerenciadorDeCorrida.cancelarCorrida();
	// }

}
