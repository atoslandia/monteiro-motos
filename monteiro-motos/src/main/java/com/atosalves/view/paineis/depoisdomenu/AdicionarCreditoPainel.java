package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.*;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import com.atosalves.view.paineis.ConstrutorPainel;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class AdicionarCreditoPainel extends ConstrutorPainel {

	public AdicionarCreditoPainel(ComponentesFactoryImpl factory) {
		super(factory);
	}

	private TextoCaixa valor;

	@Override
	protected void inicializarComponentes() {
		ComponentesFactoryImpl factory = getFactory();
		this.valor = factory.criarCaixaTexto();
	}

	@Override
	public Painel construirPainel() {
		return new PainelBuilderImpl()
			.setTexto("ADICIONAR CRÉDITO", Tema.FONTE_MUITO_FORTE)
			.setTextoCaixa("VALOR", valor)
			.setBotao("DEFINIR")
			.setBotao("VOLTAR")
			.construir();
	}
}
