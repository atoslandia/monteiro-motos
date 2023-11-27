package com.atosalves.view.paineis;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import lombok.Data;

@Data
public abstract class ConstrutorPainel {

	private ComponentesFactoryImpl factory;

	// TODO: acrescentar controller no construtor, para configurar o botão
	// talvez precisará da refência :(
	public ConstrutorPainel(ComponentesFactoryImpl factory) {
		this.factory = factory;
		inicializarComponentes();
	}

	protected abstract void inicializarComponentes();

	public abstract Painel construirPainel();
}
