package com.atosalves.controller;

import java.time.LocalDate;
import java.time.Period;

import com.atosalves.controller.exceptions.UsuarioJaExisteException;
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

public class UsuarioController {
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public boolean login(LoginDTO data) throws UsuarioNaoEncontradoException {
		Usuario usuario = usuarioDAO.recuperarPeloId(data.email()).usuario();
		if(usuario != null){
			throw new UsuarioNaoEncontradoException();
		}
		if(!usuario.getSenha().equals(data.senha())){
			throw new UsuarioNaoEncontradoException();
		}
		
		if(usuario instanceof Mototaxista && data.tipoUsuario().equals(TipoUsuario.MOTOTAXISTA)){
			return true;
		}else if(usuario instanceof Passageiro && data.tipoUsuario().equals(TipoUsuario.PASSAGEIRO)){
			return true;
		}

		return false;
	}

	public boolean cadastrar(CadastroDTO data) throws Exception {
		LocalDate dataDeNascimento = data.dataNascimento();
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataDeNascimento, dataAtual);

		if(usuarioDAO.recuperarPeloId(data.email()) != null){
			throw new UsuarioJaExisteException();
		}
		if (idade.getYears() < 18 ) {
        	throw new UsuarioMenorDeIdadeException();
        }

		FabricaSimplesUsuarios fabricaSimplesUsuarios = new FabricaSimplesUsuarios();
		Usuario usuario = fabricaSimplesUsuarios.criaUsuario(data.tipo());
		tranferirDados(data, usuario);

		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		usuarioDAO.cadastrar(usuarioDTO);
		
		return true;
	}

	private void tranferirDados(CadastroDTO dados, Usuario entidade){
		entidade.setDataNascimento(dados.dataNascimento());
		entidade.setEmail(dados.email());
		entidade.setNome(dados.nome());
		entidade.setSenha(dados.senha());
	}
}
