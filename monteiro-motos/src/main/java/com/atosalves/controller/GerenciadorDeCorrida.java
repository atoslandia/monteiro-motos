package com.atosalves.controller;

import com.atosalves.dao.CorridaDAO;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.dto.UpdateCorridaDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.Endereco;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;
import com.atosalves.observerpattern.Observador;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeCorrida implements Observador {

	@XStreamAsAttribute
	private Corrida corrida;

	@XStreamAsAttribute
	private CorridaDAO corridaDAO = new CorridaDAO();

	@XStreamAsAttribute
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public GerenciadorDeCorrida() {
		corrida = new Corrida();
	}

	@Override
	public void update(CorridaEventoDTO corrida) {
		CorridaDTO corridaDTO = new CorridaDTO(corrida.corrida());
		corridaDAO.update(corridaDTO);
		corridaDAO.moverCorrida(corrida);
	}

	public void solicitarCorrida(LoginDTO login, Endereco pontoDeEnconto, Endereco destino) {
		UsuarioDTO passageiro = usuarioDAO.recuperarPeloId(login.email());
		List<CorridaDTO> corridasDTO = corridaDAO.buscarCorridasDoUsuario(passageiro.usuario().getEmail());
		corrida = corridasDTO.get(0).corrida();
		if (corrida.getObservador() == null) {
			corrida = new Corrida(passageiro, pontoDeEnconto, destino);
			CorridaDTO corridaDTO = new CorridaDTO(corrida);
			corrida.adicionarObservador(this);
			corridaDAO.cadastrar(corridaDTO);
		} else {
			System.out.println("Cancele a corrida para poder solicitar outra");
		}
	}

	public void reivindicarCorrida(LoginDTO login, Long idCorrida) {
		corrida = corridaDAO.recuperarPeloId(idCorrida).corrida();
		UsuarioDTO mototaxista = usuarioDAO.recuperarPeloId(login.email());
		corrida.reivindicarCorrida(mototaxista);
	}

	public CorridaDTO getCorridaById(Long id) {
		corrida = corridaDAO.recuperarPeloId(id).corrida();
		return new CorridaDTO(corrida);
	}

	public void cancelarCorrida(LoginDTO login) {
		corrida.cancelarCorrida(login.tipoUsuario());
	}

	public void finalizarCorrida() {
		corrida.finalizarCorrida();
		corrida.getPassageiro().pagarCorrida(corrida.getValor());
	}

	public CorridaDTO[] buscarHistoricoDeCorridas(LoginDTO login) {
		List<CorridaDTO> corridas = corridaDAO.buscarCorridasDoUsuario(login.email());
		CorridaDTO[] corridasView = transformarEmArray(corridas);
		return corridasView;
	}

	public CorridaDTO[] buscarCorridasPendentes() {
		List<CorridaDTO> corridas = corridaDAO.buscarCorridasPendentes();
		CorridaDTO[] corridasView = transformarEmArray(corridas);
		return corridasView;
	}

	private CorridaDTO[] transformarEmArray(List<CorridaDTO> corridaArray) {
		CorridaDTO[] objects = new CorridaDTO[corridaArray.size()];
		for (int i = 0; i < objects.length; i++) {
			objects[i] = corridaArray.get(i);
		}
		return objects;
	}
}
