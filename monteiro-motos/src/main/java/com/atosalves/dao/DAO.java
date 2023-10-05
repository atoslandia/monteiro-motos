package com.atosalves.dao;

import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.LoginDTO;

public interface DAO {
	public boolean cadastrar(CadastroDTO data);

	public boolean verificarLogin(LoginDTO data);
}
