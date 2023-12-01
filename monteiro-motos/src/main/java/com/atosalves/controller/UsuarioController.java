package com.atosalves.controller;

import com.atosalves.controller.factory.FabricaSimplesUsuarios;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.model.Usuario;

public class UsuarioController {
	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public boolean login(LoginDTO data) {
		if(usuarioDAO.recuperarPeloId(data.email()) != null){
			return true;
		}
		return false;
	}

	public boolean cadastrar(CadastroDTO data) {
		FabricaSimplesUsuarios fabricaSimplesUsuarios = new FabricaSimplesUsuarios();
		Usuario usuario = fabricaSimplesUsuarios.criaUsuario(data.tipo());
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
