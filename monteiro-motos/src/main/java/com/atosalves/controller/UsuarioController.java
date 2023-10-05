package com.atosalves.controller;

import com.atosalves.dto.LoginDTO;

public class UsuarioController extends Controller {

	public void loginBotao(LoginDTO loginDTO) {
		System.out.println("login");
	}

	public void cadastroBotao() {
		System.out.println("cadastrar");
	}
}
