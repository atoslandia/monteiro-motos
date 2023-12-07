package com.atosalves.view.paineis.factorymethod;

import com.atosalves.view.componentes.abstractfactory.ComponentesFactory;
import com.atosalves.view.componentes.abstractfactory.componentesafactory.*;
import com.atosalves.view.paineis.Painel;

public abstract class PainelTemplate {

	public final ComponentesFactory COMPONENTES_FACTORY = new ComponentesFactoryImpl();
	protected Painel painel;

	public final Painel criarPainel() {
		inicializarComponentes();
		construirPainel();
		return getPainel();
	}

	protected abstract void inicializarComponentes();

	protected abstract void construirPainel();

	protected final Painel getPainel() {
		return painel;
	}
}
