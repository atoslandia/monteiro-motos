package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.InicioMenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class ExtratoPainelCreator implements PainelCreator {

	private Painel extratoPainel;

	@Override
	public void construirPainel() {
		extratoPainel =
			new PainelBuilderImpl()
				.setTexto("EXTRATO", Tema.FONTE_MUITO_FORTE)
				.setTexto("*VALOR*", Tema.FONTE_FORTE)
				.setBotao(
					"VOLTAR",
					() -> {
						extratoPainel.setPainel(new InicioMenuPainelCreator().criarPainel());
					}
				)
				.construir();
	}

	@Override
	public void inicializarComponentes() {}

	@Override
	public Painel factoryMethod() {
		return extratoPainel;
	}
}
