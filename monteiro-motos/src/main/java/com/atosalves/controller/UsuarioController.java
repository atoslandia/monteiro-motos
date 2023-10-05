package com.atosalves.controller;

import com.atosalves.dto.LoginDTO;
import com.atosalves.model.Usuario;
import com.atosalves.view.paineis.CadastroPainel;
import com.atosalves.view.paineis.PainelPadrao;

public class UsuarioController {

	private Usuario usuario;

	public UsuarioController() {}

	public void loginBotao(LoginDTO data) {
		usuario.verificarLoginUsuario(data);
	}
}
