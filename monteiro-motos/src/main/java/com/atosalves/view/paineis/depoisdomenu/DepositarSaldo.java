package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.CaixaTexto;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;

public class DepositarSaldo extends PainelPadrao {

	private CaixaTexto valor;
	private Botao depositar;
	private Botao voltar;

	@Override
	protected void construirComponentes() {
		this.valor = fabrica.criarCaixaTexto();
		this.depositar = fabrica.criarBotao();
		this.voltar = fabrica.criarBotao();

		construtor
			.texto("DEPOSITAR SALDO", Tema.FONTE_MUITO_FORTE)
			.caixaTexto("VALOR", valor)
			.botao("DEPOSITAR", depositar)
			.botao("VOLTAR", voltar)
			.construir();
	}
}
