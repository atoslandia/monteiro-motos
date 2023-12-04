package com.atosalves.dao;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.controller.UsuarioController;
import com.atosalves.dao.interfaceDAO.BuscaCorridasDAO;
import com.atosalves.dao.interfaceDAO.DAO;
import com.atosalves.db.DB;
import com.atosalves.db.Persistencia;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.statepattern.CorridaPendente;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public List<CorridaDTO> buscarCorridasEmAndamento() {
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
	// public static void main(String[] args) {
	// 	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	// 	LocalDate data = LocalDate.parse("28/02/2004", formato);
	// 	GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
	// 	CadastroDTO cadastroPassageiro = new CadastroDTO(
	// 		"robson",
	// 		"robson@gmail.com",
	// 		null,
	// 		data,
	// 		TipoUsuario.PASSAGEIRO
	// 	);
	// 	CadastroDTO cadastroMototaxista = new CadastroDTO(
	// 		"atos",
	// 		"atos@gmail.com",
	// 		null,
	// 		data,
	// 		TipoUsuario.MOTOTAXISTA
	// 		);
	// 		LoginDTO loginPassageiro = new LoginDTO(
	// 			cadastroPassageiro.email(),
	// 			null,
	// 			cadastroPassageiro.tipo()
	// 			);
	// 			LoginDTO loginMototaxista = new LoginDTO(
	// 				cadastroMototaxista.email(),
	// 				null,
	// 				cadastroMototaxista.tipo()
	// 				);

	// 				UsuarioController usuarioController = new UsuarioController();
	// 				try {
	// 					// usuarioController.cadastrar(cadastroPassageiro);
	// 					// usuarioController.cadastrar(cadastroMototaxista);
	// 	} catch (Exception e) {
	// 		System.out.println(e.getMessage());
	// 	}
	// 	gerenciadorDeCorrida.solicitarCorrida(loginPassageiro, null, null);
	// gerenciadorDeCorrida.reivindicarCorrida(loginMototaxista);
	// gerenciadorDeCorrida.solicitarCorrida(loginPassageiro, null, null);
	// gerenciadorDeCorrida.cancelarCorrida(loginPassageiro);
	// gerenciadorDeCorrida.solicitarCorrida(loginPassageiro, null, null);
	// gerenciadorDeCorrida.cancelarCorrida();
	// }

}
