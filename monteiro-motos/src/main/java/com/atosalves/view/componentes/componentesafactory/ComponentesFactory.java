package com.atosalves.view.componentes.componentesafactory;

import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;
import java.awt.Font;

public class ComponentesFactory {

	public SenhaCaixa criarCaixaSenha() {
		return new SenhaCaixa();
	}

	public TextoCaixa criarCaixaTexto() {
		return new TextoCaixa();
	}

	public Texto criarTexto(String texto, Font fonte) {
		return new Texto(texto, fonte);
	}

	public DataCaixa criarDataCaixa() {
		return new DataCaixa();
	}

	public TipoUsuarioCombo criarComboTipoUsuario() {
		return new TipoUsuarioCombo(TiposUsuario.values());
	}

	public Botao criarBotao(String titulo) {
		return new Botao(titulo);
	}

	public Botao criarBotaoMenu(String titulo) {
		return new BotaoMenu(titulo);
	}
}
