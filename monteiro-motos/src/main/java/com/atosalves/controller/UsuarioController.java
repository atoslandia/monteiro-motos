package com.atosalves.controller;

import com.atosalves.controller.exceptions.CredenciaisException;
import com.atosalves.controller.exceptions.UsuarioMenorDeIdadeException;
import com.atosalves.controller.factory.FabricaSimplesUsuarios;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dao.exceptions.UsuarioNaoEncontradoException;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;
import java.time.LocalDate;
import java.time.Period;

public class UsuarioController {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void login(LoginDTO data) throws CredenciaisException {
		Usuario usuario = usuarioDAO.recuperarPeloId(data.email()).usuario();
		if (usuario == null) {
			throw new CredenciaisException("Usuario não encontrado");
		}
		if (!usuario.getSenha().equals(data.senha())) {
			throw new CredenciaisException("Senha incorreta");
		}

		if (usuario instanceof Mototaxista && data.tipoUsuario().equals(TipoUsuario.PASSAGEIRO)) {
			return;
		} else if (usuario instanceof Passageiro && data.tipoUsuario().equals(TipoUsuario.MOTOTAXISTA)) {
			return;
		}
		throw new CredenciaisException("Tipo de usuario incorreto");
	}

	public void cadastrar(CadastroDTO data) throws CredenciaisException {
		LocalDate dataDeNascimento = data.dataNascimento();
		LocalDate dataAtual = LocalDate.now();
		Period idade = Period.between(dataDeNascimento, dataAtual);

		if (usuarioDAO.recuperarPeloId(data.email()) != null) {
			throw new CredenciaisException("Esse email já foi cadastrado");
		}
		if (idade.getYears() < 18) {
			throw new CredenciaisException("Idade invalida. Permitido acima de 18 anos");
		}

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
}
