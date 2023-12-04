package com.atosalves.controller;

import com.atosalves.dao.CorridaDAO;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.EnderecoDTO;
import com.atosalves.dto.EnderecoViewDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.model.Corrida;
import com.atosalves.model.Endereco;
import com.atosalves.model.exceptions.AcessoNegadoException;
import com.atosalves.observerpattern.Observador;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import java.util.List;

public class GerenciadorDeCorrida implements Observador {

	@XStreamAsAttribute
	private CorridaDAO corridaDAO = new CorridaDAO();

	@XStreamAsAttribute
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	@Override
	public void update(CorridaEventoDTO corrida) {
		CorridaDTO corridaDTO = new CorridaDTO(corrida.corrida());
		corridaDAO.update(corridaDTO);
		corridaDAO.moverCorrida(corrida);
	}

	public CorridaDTO solicitarCorrida(LoginDTO loginDTO, EnderecoViewDTO pontoDeEncontoDTO, EnderecoViewDTO destinoDTO) {
		UsuarioDTO passageiro = usuarioDAO.recuperarPeloId(loginDTO.email());
		CorridaDTO corridaDTO = corridaDAO.buscarCorridaExistenteDeUmPassageiro(loginDTO);

		if (corridaDTO == null) {
			Endereco pontoDeEncontro = new Endereco(
				pontoDeEncontoDTO.bairro(),
				pontoDeEncontoDTO.rua(),
				pontoDeEncontoDTO.cep());
			Endereco destino = new Endereco(destinoDTO.bairro(), destinoDTO.rua(), destinoDTO.cep());

			Corrida corrida = new Corrida(passageiro, new EnderecoDTO(pontoDeEncontro), new EnderecoDTO(destino));

			corridaDTO = new CorridaDTO(corrida);
			corrida.adicionarObservador(this);
			corridaDAO.cadastrar(corridaDTO);
		}
		return corridaDTO;
	}

	public void reivindicarCorrida(LoginDTO login, CorridaDTO corridaDTO) throws AcessoNegadoException {
		Corrida corrida = corridaDAO
			.buscarUmaCorridaDoUsuario(
				corridaDTO.corrida().getPassageiro().getEmail(),
				corridaDTO.corrida().getEstado().getNome()
			)
			.corrida();
		UsuarioDTO mototaxista = usuarioDAO.recuperarPeloId(login.email());
		corrida.reivindicarCorrida(mototaxista);
	}

	public CorridaDTO buscarCorridaPeloId(Long id) {
		Corrida corrida = corridaDAO.recuperarPeloId(id).corrida();
		return new CorridaDTO(corrida);
	}

	// TODO: consertar
	public void cancelarCorrida(LoginDTO login, CorridaDTO corridaDTO) throws AcessoNegadoException {
		Corrida corrida = corridaDAO.recuperarPeloId(corridaDTO.corrida().getId()).corrida();
		corrida.cancelarCorrida(login.tipoUsuario());
	}

	public void finalizarCorrida(CorridaDTO corridaDTO) throws AcessoNegadoException {
		Corrida corrida = corridaDAO.recuperarPeloId(corridaDTO.corrida().getId()).corrida();
		corrida.finalizarCorrida();
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
