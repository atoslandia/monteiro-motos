package com.atosalves.controller;

import com.atosalves.controller.factory.FabricaSimplesUsuarios;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;

public class UsuarioController {
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public boolean login(LoginDTO data) {
		if(usuarioDAO.recuperarPeloId(data.email()) != null){
			return true;
		}
		return false;
	}

	public boolean cadastrarPassageiro(CadastroDTO data) {
		Passageiro usuario = new Passageiro();
		tranferirDados(data, usuario);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDAO.cadastrar(usuarioDTO);
	}

	public boolean cadastrarMototaxista(CadastroDTO data){
		Mototaxista usuario = new Mototaxista();
		tranferirDados(data, usuario);
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
		return usuarioDAO.cadastrar(usuarioDTO);
	}

	private void tranferirDados(CadastroDTO dados, Usuario entidade){
		entidade.setDataNascimento(dados.dataNascimento());
		entidade.setEmail(dados.email());
		entidade.setNome(dados.nome());
		entidade.setSenha(dados.senha());
	}
}
