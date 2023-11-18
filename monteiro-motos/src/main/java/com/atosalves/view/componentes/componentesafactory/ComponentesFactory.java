package com.atosalves.view.componentes.componentesafactory;

import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;

public class ComponentesFactory {

	public CaixaSenha criarCaixaSenha() {
		return new CaixaSenha();
	}

	public CaixaTexto criarCaixaTexto() {
		return new CaixaTexto();
	}

	public Texto criarTexto(String texto) {
		return new Texto(texto);
	}

	public TipoUsuarioCombo criarComboTipoUsuario() {
		return new TipoUsuarioCombo(TiposUsuario.values());
	}

	public Botao criarBotao() {
		return new Botao();
	}

	public Botao criarBotaoMenu() {
		return new BotaoMenu();
	}
}
