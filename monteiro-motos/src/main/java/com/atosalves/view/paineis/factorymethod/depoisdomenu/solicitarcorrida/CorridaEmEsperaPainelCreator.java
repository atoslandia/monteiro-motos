package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridaEmEsperaPainelCreator implements PainelCreator {

	private Painel corridaEmEsperaPainel;

	private GerenciadorDeCorrida gerenciadorDeCorrida;

	public CorridaEmEsperaPainelCreator(GerenciadorDeCorrida gerenciadorDeCorrida) {
		this.gerenciadorDeCorrida = gerenciadorDeCorrida;
	}

	private void cancelarCorridaBotao() {
		gerenciadorDeCorrida.cancelarCorrida(corridaEmEsperaPainel.getLoginDTO());

		corridaEmEsperaPainel.setPainel(new MenuPainelCreator().criarPainel());
	}

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		corridaEmEsperaPainel =
			new PainelBuilderImpl()
				.setTexto("CORRIDA EM ESPERA", Tema.FONTE_MUITO_FORTE)
				.setBotao("CANCELAR CORRIDA", this::cancelarCorridaBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return corridaEmEsperaPainel;
	}
}
