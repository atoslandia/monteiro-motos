package com.atosalves.view.paineis.factorymethod.depoisdomenu.detalhescorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridaEmAndamentoPainelCreator implements PainelCreator {

	private Painel corridaEmAndamentoPainel;

	private LoginDTO loginDTO;
	private Long idCorrida;

	private GerenciadorDeCorrida gerenciadorDeCorrida;

	public CorridaEmAndamentoPainelCreator(LoginDTO loginDTO, Long idCorrida) {
		this.loginDTO = loginDTO;
		this.idCorrida = idCorrida;
		this.gerenciadorDeCorrida = new GerenciadorDeCorrida();
	}

	private void finalizarBotao() {
		try {
			gerenciadorDeCorrida.finalizarCorrida(idCorrida);
			corridaEmAndamentoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
		} catch (Exception e) {
			new JanelaDeErro(e.getMessage());
		}
	}

	private void cancelarBotao() {
		try {
			gerenciadorDeCorrida.cancelarCorrida(loginDTO, idCorrida);
			corridaEmAndamentoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
		} catch (Exception e) {
			new JanelaDeErro(e.getMessage());
		}
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
