package com.atosalves.model;

import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.LoginDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	private String nome;
	private String email;
	private String senha;

	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	private UsuarioDAO usuarioDAO;

	public boolean verificarLoginUsuario(LoginDTO data) {
		return usuarioDAO.verificarLogin(data);
	}

	public void cadastrarUsuario(CadastroDTO data) {
		usuarioDAO.cadastrar(data);
	}
}
