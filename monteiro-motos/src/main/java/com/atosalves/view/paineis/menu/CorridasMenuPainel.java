package com.atosalves.view.paineis.menu;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.ConstrutorPainel;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridasMenuPainel extends ConstrutorPainel {

	public CorridasMenuPainel(ComponentesFactory factory) {
		super(factory);
	}

	@Override
	protected void inicializarComponentes() {}

	@Override
	public Painel construirPainel() {
		Painel painel = new PainelBuilderImpl()
			.setTexto("CORRIDAS", Tema.FONTE_MUITO_FORTE)
			.setBotaoMenu("INICIO")
			.setBotaoMenu("CORRIDAS")
			.setBotaoMenu("EDITAR")
			.setBotao("SAIR")
			.construir();

		painel.getBotao("CORRIDAS").setBounds(199, 300, 345, 80);
		painel.getBotao("CORRIDAS").setEnabled(false);

		painel.getBotao("INICIO").setBounds(0, 300, 200, 80);
		painel.getBotao("EDITAR").setBounds(543, 300, 210, 80);

		painel.getBotao("SAIR").setBounds(630, 10, 100, 35);

		return painel;
	}
}
