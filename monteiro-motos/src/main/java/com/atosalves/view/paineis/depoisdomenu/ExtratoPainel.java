package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import com.atosalves.view.paineis.ConstrutorPainel;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class ExtratoPainel extends ConstrutorPainel {

	public ExtratoPainel(ComponentesFactoryImpl factory) {
		super(factory);
	}

	@Override
	public Painel construirPainel() {
		return new PainelBuilderImpl()
			.setTexto("EXTRATO", Tema.FONTE_MUITO_FORTE)
			.setTexto("*VALOR*", Tema.FONTE_FORTE)
			.setBotao("VOLTAR")
			.construir();
	}

	@Override
	protected void inicializarComponentes() {}
}
