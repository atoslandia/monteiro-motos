package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import com.atosalves.view.paineis.ConstrutorPainel;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DepositarSaldo extends ConstrutorPainel {

	private TextoCaixa valor;

	public DepositarSaldo(ComponentesFactoryImpl factory) {
		super(factory);
	}

	@Override
	protected void inicializarComponentes() {
		ComponentesFactoryImpl factory = getFactory();
		this.valor = factory.criarCaixaTexto();
	}

	@Override
	public Painel construirPainel() {
		return new PainelBuilderImpl()
			.setTexto("DEPOSITAR SALDO", Tema.FONTE_MUITO_FORTE)
			.setTextoCaixa("VALOR", valor)
			.setBotao("DEPOSITAR")
			.setBotao("VOLTAR")
			.construir();
	}
}
