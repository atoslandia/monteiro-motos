package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DepositarSaldo extends Painel {

	private TextoCaixa valor;
	private Botao depositar;
	private Botao voltar;

	@Override
	protected void inicializarComponentes(ComponentesFactory fabrica) {
		this.valor = fabrica.criarCaixaTexto();
		this.depositar = fabrica.criarBotao("DEPOSITAR");
		this.voltar = fabrica.criarBotao("VOLTAR");
	}

	@Override
	protected Painel montarComponentes(PainelBuilderImpl construtor) {
		return construtor
			.setTexto("DEPOSITAR SALDO", Tema.FONTE_MUITO_FORTE)
			.setTextoCaixa("VALOR", valor)
			.setBotao(depositar)
			.setBotao(voltar)
			.construir();
	}
}
