package com.atosalves.view.paineis.factorymethod.depoisdomenu.detalhescorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridaEmAndamentoPainelCreator implements PainelCreator {

	private Painel corridaEmAndamentoPainel;

	private LoginDTO loginDTO;

	private GerenciadorDeCorrida gerenciadorDeCorrida;

	public CorridaEmAndamentoPainelCreator(LoginDTO loginDTO, GerenciadorDeCorrida gerenciadorDeCorrida) {
		this.loginDTO = loginDTO;
		this.gerenciadorDeCorrida = gerenciadorDeCorrida;
	}

	private void finalizarBotao() {
		gerenciadorDeCorrida.finalizarCorrida();
		corridaEmAndamentoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	private void cancelarBotao() {
		gerenciadorDeCorrida.cancelarCorrida(loginDTO);
		corridaEmAndamentoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		corridaEmAndamentoPainel =
			new PainelBuilderImpl()
				.setTexto("CORRIDA EM ANDAMENTO", Tema.FONTE_MUITO_FORTE)
				.setBotao("FINALIZAR", this::finalizarBotao)
				.setBotao("CANCELAR", this::cancelarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return corridaEmAndamentoPainel;
	}
}
