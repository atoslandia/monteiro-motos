package com.atosalves.controller;

import com.atosalves.controller.chainpattern.TratadorEtapa;
import com.atosalves.controller.chainpattern.TratadorEmail;
import com.atosalves.controller.chainpattern.TratadorIdade;
import com.atosalves.controller.chainpattern.TratadorSenha;
import com.atosalves.controller.chainpattern.TratadorTipo;
import com.atosalves.controller.exceptions.CredenciaisInvalidasException;
import com.atosalves.controller.factory.FabricaSimplesUsuarios;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.usuario.CadastroDTO;
import com.atosalves.dto.usuario.GerenciadorDePagamentoDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.dto.usuario.PassageiroBoletoDTO;
import com.atosalves.dto.usuario.UpdateUsuarioViewDTO;
import com.atosalves.dto.usuario.UsuarioDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Avaliacao;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;
import com.atosalves.model.facadepattern.MensageiroFacade;

import java.util.List;

public class UsuarioController {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void login(LoginDTO data) throws CredenciaisInvalidasException {
		UsuarioDTO usuarioDTO = usuarioDAO.recuperarPeloId(data.email());
		TratadorEtapa tratadorEmail = new TratadorEmail();
		TratadorEtapa tratadorSenha = new TratadorSenha();
		TratadorEtapa tratadorTipo = new TratadorTipo();

		tratadorEmail.setProximoTratador(tratadorSenha);
		tratadorSenha.setProximoTratador(tratadorTipo);

		tratadorEmail.tratarRequisicao(data, usuarioDTO);
	}

	public void cadastrar(CadastroDTO data) throws CredenciaisInvalidasException {
		TratadorEtapa tratadorEmail = new TratadorEmail();
		TratadorEtapa tratadorIdade = new TratadorIdade();
		tratadorEmail.setProximoTratador(tratadorIdade);
		tratadorEmail.tratarRequisicao(data);

		FabricaSimplesUsuarios fabricaSimplesUsuarios = new FabricaSimplesUsuarios();
		Usuario usuario = fabricaSimplesUsuarios.criaUsuario(data.tipo());
		tranferirDados(data, usuario);
		
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		usuarioDAO.cadastrar(usuarioDTO);
	}
	
	private void tranferirDados(CadastroDTO dados, Usuario entidade) {
		entidade.setDataNascimento(dados.dataNascimento());
		entidade.setEmail(dados.email());
		entidade.setNome(dados.nome());
		entidade.setSenha(dados.senha());
	}

	public void enviarExtrato(LoginDTO login){
		UsuarioDTO usuarioDTO = usuarioDAO.recuperarPeloId(login.email());
		Passageiro passageiro = (Passageiro) usuarioDTO.usuario();
		MensageiroFacade.enviarExtratoPorEmail(login.email(), new GerenciadorDePagamentoDTO(passageiro.getGerenciadorDePagamento()));
	}


	public void editar(UpdateUsuarioViewDTO updateUsuarioDTO, String email) {
		Usuario usuario = usuarioDAO.recuperarPeloId(email).usuario();
		usuario.setNome(updateUsuarioDTO.nome());
		usuario.setSenha(updateUsuarioDTO.senha());
		usuarioDAO.update(new UsuarioDTO(usuario), email);
	}

	public void excluirUsuario(String email) {
		usuarioDAO.deletePeloId(email);
	}

	public String buscarNomeUsuario(String email) {
		UsuarioDTO usuarioDTO = usuarioDAO.recuperarPeloId(email);
		return usuarioDTO.usuario().getNome();
	}

	public void depositarNaConta(LoginDTO login, float valor) {
		Passageiro passageiro = (Passageiro) usuarioDAO.recuperarPeloId(login.email()).usuario();
		passageiro.depositar(valor);
		usuarioDAO.update(new UsuarioDTO(passageiro), login.email());
		MensageiroFacade.enviarBoletoPorEmail(new PassageiroBoletoDTO(passageiro.getNome(), passageiro.getEmail()), valor);
	}

	public float avaliacaoMediaDoMototaxista(LoginDTO login) {
		Mototaxista mototaxista = (Mototaxista) usuarioDAO.recuperarPeloId(login.email()).usuario();
		List<Avaliacao> avaliacoes = mototaxista.getAvaliacoes();
		float media = 0;
		if (avaliacoes == null) {
			return media;
		}
		float soma = 0;
		for (Avaliacao avaliacao : avaliacoes) {
			soma += avaliacao.getEstrelas();
		}
		media = soma / avaliacoes.size();
		return media;
	}

	public float consultarSaldo(LoginDTO login) {
		Usuario usuario = usuarioDAO.recuperarPeloId(login.email()).usuario();

		if (usuario.getTipo().equals(TipoUsuario.PASSAGEIRO)) {
			Passageiro passageiro = (Passageiro) usuario;
			return passageiro.getGerenciadorDePagamento().getSaldo();
		}
		Mototaxista mototaxista = (Mototaxista) usuario;
		return mototaxista.getLucro();
	}
}
