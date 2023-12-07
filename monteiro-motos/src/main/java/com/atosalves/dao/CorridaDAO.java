package com.atosalves.dao;

import com.atosalves.dao.interfaceDAO.BuscaCorridasDAO;
import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.db.DB;
import com.atosalves.dto.corrida.CorridaDTO;
import com.atosalves.dto.corrida.CorridaEventoDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.model.Corrida;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.ArrayList;
import java.util.List;

public class CorridaDAO implements DAO<CorridaDTO, Long>, BuscaCorridasDAO {

	@XStreamAsAttribute
	private DB dataBase;

	public CorridaDAO() {
		dataBase = DB.getInstance();
	}

	@Override
	public void cadastrar(CorridaDTO entidade) {
		Corrida corrida = entidade.corrida();
		EstadoCorrida chave = entidade.corrida().getEstado().getNome();
		dataBase.getCorridas().get(chave).add(corrida);
		dataBase.salvarDados();
	}

	@Override
	public CorridaDTO recuperarPeloId(Long id) {
		for (ArrayList<Corrida> c : dataBase.getCorridas().values()) {
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
		CorridaDTO corridaDTO = recuperarPeloId(id);
		EstadoCorrida chave = corridaDTO.corrida().getEstado().getNome();
		dataBase.getCorridas().get(chave).remove(corridaDTO.corrida());
		dataBase.salvarDados();
	}


	@Override
	public List<CorridaDTO> buscarCorridaPeloEstado(EstadoCorrida estadoCorrida) {
		List<CorridaDTO> corridasDTO = new ArrayList<>();

		for (Corrida corrida : dataBase.getCorridas().get(estadoCorrida)) {
			CorridaDTO corridaDTO = new CorridaDTO(corrida);
			corridasDTO.add(corridaDTO);
		}

		return corridasDTO;
	}

	@Override
	public void moverCorrida(CorridaEventoDTO evento) {
		Corrida corrida = recuperarPeloId(evento.corrida().getId()).corrida();
		dataBase.getCorridas().get(evento.estadoAntigo()).remove(corrida);
		dataBase.getCorridas().get(evento.corrida().getEstado().getNome()).add(corrida);

		dataBase.salvarDados();
	}
	
	@Override
	public CorridaDTO update(CorridaDTO entidade, Long id) {
		Corrida corrida = recuperarPeloId(id).corrida();
		corrida = entidade.corrida();
		dataBase.salvarDados();
		return new CorridaDTO(corrida);
	}

	@Override
	public List<CorridaDTO> buscarCorridasDoUsuario(String id) {
		List<CorridaDTO> corridasDoUsuario = new ArrayList<>();

		for (ArrayList<Corrida> c : dataBase.getCorridas().values()) {
			for (Corrida corrida : c) {
				if (id.equals(corrida.getPassageiro().getEmail())) {
					CorridaDTO corridaDTO = new CorridaDTO(corrida);
					corridasDoUsuario.add(corridaDTO);
				}
				if (corrida.getMototaxista() != null &&  (id.equals(corrida.getMototaxista().getEmail()))) {
						CorridaDTO corridaDTO = new CorridaDTO(corrida);
						corridasDoUsuario.add(corridaDTO);
					
				}
			}
		}
		return corridasDoUsuario;
	}

	@Override
	public CorridaDTO buscarCorridaReivindicadaMototaxista(String id) {
		List<CorridaDTO> corridasReivindicadas = buscarCorridaPeloEstado(EstadoCorrida.REINVINDICADA);
		for (CorridaDTO corridaDTO : corridasReivindicadas) {
			if (corridaDTO.corrida().getMototaxista().getEmail().equals(id)) {
				return corridaDTO;
			}
		}
		return null;
	}

}
