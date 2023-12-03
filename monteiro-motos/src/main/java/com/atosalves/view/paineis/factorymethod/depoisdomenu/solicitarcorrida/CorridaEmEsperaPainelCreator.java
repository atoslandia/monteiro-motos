package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridaEmEsperaPainelCreator implements PainelCreator {

	private Painel corridaEmEsperaPainel;

	private GerenciadorDeCorrida gerenciadorDeCorrida;

	private LoginDTO loginDTO;

	public CorridaEmEsperaPainelCreator(
		GerenciadorDeCorrida gerenciadorDeCorrida,
		LoginDTO loginDTO
	) {
		this.gerenciadorDeCorrida = gerenciadorDeCorrida;
		this.loginDTO = loginDTO;
	}

	private void cancelarCorridaBotao() {
		gerenciadorDeCorrida.cancelarCorrida(loginDTO);

		corridaEmEsperaPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
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
