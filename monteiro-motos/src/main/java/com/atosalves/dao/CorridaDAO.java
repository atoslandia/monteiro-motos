package com.atosalves.dao;

import com.atosalves.dao.interfaceDAO.BuscaCorridasDAO;
import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.db.DB;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.LoginDTO;
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
		try {
			CorridaDTO corridaDTO = recuperarPeloId(id);
			EstadoCorrida chave = corridaDTO.corrida().getEstado().getNome();
			dataBase.getCorridas().get(chave).remove(corridaDTO.corrida());
			dataBase.salvarDados();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<CorridaDTO> buscarCorridasPendentes() {
		List<CorridaDTO> corridasDTO = new ArrayList<>();

		for (Corrida corrida : dataBase.getCorridas().get(EstadoCorrida.PENDENTE)) {
			CorridaDTO corridaDTO = new CorridaDTO(corrida);
			corridasDTO.add(corridaDTO);
		}

		return corridasDTO;
	}

	@Override
	public List<CorridaDTO> buscarCorridasReinvidicadas() {
		List<CorridaDTO> corridasDTO = new ArrayList<>();

		for (Corrida corrida : dataBase.getCorridas().get(EstadoCorrida.REINVINDICADA)) {
			CorridaDTO corridaDTO = new CorridaDTO(corrida);
			corridasDTO.add(corridaDTO);
		}

		return corridasDTO;
	}

	@Override
	public List<CorridaDTO> buscarCorridasCanceladas() {
		List<CorridaDTO> corridasDTO = new ArrayList<>();

		for (Corrida corrida : dataBase.getCorridas().get(EstadoCorrida.CANCELADA)) {
			CorridaDTO corridaDTO = new CorridaDTO(corrida);
			corridasDTO.add(corridaDTO);
		}

		return corridasDTO;
	}

	@Override
	public List<CorridaDTO> buscarCorridasFinalizadas() {
		List<CorridaDTO> corridasDTO = new ArrayList<>();

		for (Corrida corrida : dataBase.getCorridas().get(EstadoCorrida.FINALIZADA)) {
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

	public CorridaDTO update(CorridaDTO entidade) {
		Corrida corrida = recuperarPeloId(entidade.corrida().getId()).corrida();
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
			}
		}
		return corridasDoUsuario;
	}

	@Override
	// TODO: ver esse método
	public CorridaDTO buscarUmaCorridaDoUsuario(String id, EstadoCorrida estado) {
		ArrayList<Corrida> corridas = dataBase.getCorridas().get(estado);

		if (corridas != null) {
			for (Corrida corrida : corridas) {
				if (corrida.getPassageiro().getEmail().equals(id)) {
					return new CorridaDTO(corrida);
				}
			}
		}
		return null;
	}

	public CorridaDTO buscarCorridaExistenteDeUmPassageiro(LoginDTO loginDTO) {
		List<CorridaDTO> listaPendentes = buscarCorridasReinvidicadas();
		List<CorridaDTO> listaReinvindicados = buscarCorridasPendentes();

		if (listaPendentes != null) {
			for (CorridaDTO c : listaPendentes) {
				if (loginDTO.email().equals(c.corrida().getPassageiro().getEmail())) {
					return c;
				}
			}
		}
		if (listaReinvindicados != null) {
			for (CorridaDTO c : listaReinvindicados) {
				if (loginDTO.email().equals(c.corrida().getPassageiro().getEmail())) {
					return c;
				}
			}
		}
		return null;
	}
	
	@Override
	public CorridaDTO buscarCorridaReivindicadaMototaxista(String id) {
		List<Corrida> corridasReivindicadas = dataBase.getCorridas().get(EstadoCorrida.REINVINDICADA);
		for (Corrida corrida : corridasReivindicadas) {
			if(corrida.getMototaxista().getEmail().equals(id)){
				return new CorridaDTO(corrida);
			}
		}
		return null;
	}


}
