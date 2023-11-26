package com.atosalves.view.paineis;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import lombok.Data;

@Data
public abstract class ConstrutorPainel {

	private ComponentesFactory factory;

	public ConstrutorPainel(ComponentesFactory factory) {
		this.factory = factory;
		inicializarComponentes();
	}

	public abstract Painel construirPainel();

	protected abstract void inicializarComponentes();
}
