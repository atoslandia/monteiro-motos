package com.atosalves.view.paineis.factorymethod;

import com.atosalves.view.componentes.abstractfactory.ComponentesFactory;
import com.atosalves.view.componentes.abstractfactory.componentesafactory.*;
import com.atosalves.view.paineis.Painel;

public interface PainelCreator {
	public final ComponentesFactory COMPONENTES_FACTORY = new ComponentesFactoryImpl();

	void inicializarComponentes();
	void construirPainel();

	default Painel criarPainel() {
		inicializarComponentes();
		construirPainel();
		return factoryMethod();
	}

	Painel factoryMethod();
}
