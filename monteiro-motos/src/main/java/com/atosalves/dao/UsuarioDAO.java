package com.atosalves.dao;

import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.LoginDTO;

// TODO classe para conectar com o banco de dados
public class UsuarioDAO implements DAO {

	@Override
	public boolean cadastrar(CadastroDTO data) {
		// TODO aplicar lógica
		return true;
	}

	@Override
	public boolean verificarLogin(LoginDTO data) {
		// TODO aplicar lógica
		return true;
	}
}
