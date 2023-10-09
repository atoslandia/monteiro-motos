package com.atosalves.view.componentes.componentesafactory;

import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;

public class ComponentesFactory {

	public SenhaCaixa criarCaixaSenha() {
		return new SenhaCaixa();
	}

	public TextoCaixa criarCaixaTexto() {
		return new TextoCaixa();
	}

	public Texto criarTexto(String texto) {
		return new Texto(texto);
	}

	public TipoUsuarioCombo criarComboTipoUsuario(TiposUsuario[] tipos) {
		return new TipoUsuarioCombo(tipos);
	}

	public Botao criarBotao() {
		return new Botao();
	}
}
