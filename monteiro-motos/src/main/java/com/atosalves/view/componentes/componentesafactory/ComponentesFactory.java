package com.atosalves.view.componentes.componentesafactory;

import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;

public class ComponentesFactory {

	public CaixaSenhaComponente criarCaixaSenha() {
		return new CaixaSenhaComponente();
	}

	public CaixaTextoComponente criarCaixaTexto() {
		return new CaixaTextoComponente();
	}

	public Texto criarTexto(String texto) {
		return new Texto(texto);
	}

	public TipoUsuarioCombo criarComboTipoUsuario(TiposUsuario[] tipos) {
		return new TipoUsuarioCombo(tipos);
	}

	public BotaoComponente criarBotao() {
		return new BotaoComponente();
	}

	public BotaoComponente criarBotaoMenu() {
		return new BotaoMenu();
	}
}
