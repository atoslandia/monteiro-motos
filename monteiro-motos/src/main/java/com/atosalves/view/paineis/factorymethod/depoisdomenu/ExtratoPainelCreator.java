package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class ExtratoPainelCreator implements PainelCreator {

	private Painel extratoPainel;

	private void voltarBotao() {
		extratoPainel.setPainel(new MenuPainelCreator().criarPainel());
	}

	@Override
	public void construirPainel() {
		extratoPainel =
			new PainelBuilderImpl()
				.setTexto("EXTRATO", Tema.FONTE_MUITO_FORTE)
				// TODO: consultar controller para retornas uma lista com o extrato
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public void inicializarComponentes() {}

	@Override
	public Painel factoryMethod() {
		return extratoPainel;
	}
}
