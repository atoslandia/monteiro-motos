package com.atosalves.controller;

import com.atosalves.view.JanelaPrincipal;
import com.atosalves.view.paineis.LoginPainel;

public class TrocadorDeTelaController extends Controller {

	public void iniciarTela() {
		var janela = new JanelaPrincipal();

		var controllerUsuario = new UsuarioController();

		var painelLogin = new LoginPainel();
		painelLogin.setController(controllerUsuario);

		janela.setPainel(painelLogin);
	}
}
