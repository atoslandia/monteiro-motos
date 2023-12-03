package com.atosalves.controller;

import java.util.ArrayList;
import java.util.List;

import com.atosalves.dao.CorridaDAO;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.dto.UpdateCorridaDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.Endereco;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;
import com.atosalves.observerpattern.Observador;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

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
		CorridaDTO corridaDTO = corridaDAO.buscarCorridaDeUmUsuario(
			passageiro.usuario().getEmail(),
			"Pendente"
		);
		if (corridaDTO == null) {
			corrida = new Corrida(passageiro, pontoDeEnconto, destino);
			corridaDTO = new CorridaDTO(corrida);
			corrida.adicionarObservador(this);
			corridaDAO.cadastrar(corridaDTO);
		} else {
			corrida = corridaDTO.corrida();
			System.out.println("Cancele a corrida para poder solicitar outra");
		}
	}

	public void reivindicarCorrida(LoginDTO login, Long id) {
		corrida = corridaDAO.recuperarPeloId(id).corrida();
		UsuarioDTO mototaxista = usuarioDAO.recuperarPeloId(login.email());
		corrida.reivindicarCorrida(mototaxista);
	}

	public void cancelarCorrida(LoginDTO login) {
		corrida.cancelarCorrida(login.tipoUsuario());
	}

	public void finalizarCorrida() {
		corrida.finalizarCorrida();
		corrida.getPassageiro().pagarCorrida(corrida.getValor());
	}

	public Object[] buscarCorridasPendentes(){
		List<Corrida> corridas = corridaDAO.buscarCorridasPendenetes();
		Object[] corridasView = transformarEmArray(corridas);
		return corridasView;
	}

	private Object[] transformarEmArray(List<Corrida> corridaArray){
		Object[] objects = new Object[corridaArray.size()];
		for (int i = 0; i < objects.length; i++) {
			Corrida corrida = corridaArray.get(i);
			objects[i] = corrida.getId() + " | " 
			+ corrida.getPontoDeEncontro().getRua() + " | " 
			+ corrida.getDestino().getRua();
		}
		return objects;
	}

}
