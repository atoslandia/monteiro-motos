package com.atosalves.dao;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dao.interfaceDAO.BuscaCorridasDAO;
import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.dao.interfaceDAO.UpdateDAO;
import com.atosalves.db.Persistencia;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.PassageiroBoletoDTO;
import com.atosalves.dto.UpdateCorridaDTO;
import com.atosalves.dto.UpdateUsuarioDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;
import com.atosalves.model.facadepattern.MensageiroFacade;
import com.atosalves.observerpattern.Observador;
import com.atosalves.observerpattern.Observavel;

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
			corridas.get(entidade.corrida().getEstado().getNome()).add(corrida);
			persistencia.salvarCorridas(corridas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
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


	
	public static void main(String[] args) {
		GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
		Passageiro p = new Passageiro("Robson", null, null, null);
		Mototaxista m = new Mototaxista("Atos", null, null, null);
		gerenciadorDeCorrida.solicitarCorrida(p, null, null);
		gerenciadorDeCorrida.reivindicarCorrida(m);
		gerenciadorDeCorrida.solicitarCorrida(p, null, null);
		gerenciadorDeCorrida.cancelarCorrida();
		gerenciadorDeCorrida.solicitarCorrida(p, null, null);
		// gerenciadorDeCorrida.cancelarCorrida();
	}






}
