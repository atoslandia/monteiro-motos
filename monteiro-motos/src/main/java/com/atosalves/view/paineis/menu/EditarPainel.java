package com.atosalves.view.paineis.menu;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.paineis.PainelInterno;
import com.atosalves.view.paineis.PainelPadrao;

public class EditarPainel extends PainelPadrao {

	private Botao editar;

	private PainelInterno painel;

	@Override
	protected void construirComponentes() {
		construtor.painel(painel).botao("EDITAR", editar).construir();
	}

	@Override
	protected void instanciarComponentes() {} //TODO
}
