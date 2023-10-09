package com.atosalves.view.paineis;

import com.atosalves.view.componentes.Botao;

public class MenuPainel extends PainelPadrao {

	private Botao listar;
	private Botao valorCredito;
	private Botao caixa;

	@Override
	protected void construirComponentes() {
		construtor
			.texto("INICIO")
			.botao("LISTAR TODOS OS USUÁRIOS", listar)
			.botao("DEFINIR VALOR DE CRÉTIDO DE REINVIDICAÇÃO", valorCredito)
			.botao("DADOS DO CAIXA", caixa)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.listar = fabrica.criarBotao();
		this.valorCredito = fabrica.criarBotao();
		this.caixa = fabrica.criarBotao();
	}
}
