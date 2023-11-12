package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.menu.InicioMenuPainel;

public class ValorCreditoPainel extends PainelPadrao {

	private CaixaTextoComponente valor;
	private BotaoComponente definir;
	private BotaoComponente voltar;

	public ValorCreditoPainel() {
		voltar();
	}

	private void voltar() {
		voltar.aoClicar(() -> setPainel(new InicioMenuPainel()));
	}

	@Override
	protected void construirComponentes() {
		this.valor = fabrica.criarCaixaTexto();
		this.definir = fabrica.criarBotao();
		this.voltar = fabrica.criarBotao();

		construtor
			.caixaTexto("VALOR", valor)
			.botao("DEFINIR", definir)
			.botao("VOLTAR", voltar)
			.construir();
	}
}
