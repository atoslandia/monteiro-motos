package com.atosalves.view.paineis;

import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.menu.MenuPainel;

public class ValorCreditoPainel extends PainelPadrao {

	private CaixaTexto valor;
	private Botao definir;
	private Botao voltar;

	public ValorCreditoPainel() {
		voltar();
	}

	private void voltar() {
		voltar.aoClicar(() -> setPainel(new MenuPainel()));
	}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("VALOR", valor)
			.botao("DEFINIR", definir)
			.botao("VOLTAR", voltar)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.valor = fabrica.criarCaixaTexto();
		this.definir = fabrica.criarBotao();
		this.voltar = fabrica.criarBotao();
	}
}
