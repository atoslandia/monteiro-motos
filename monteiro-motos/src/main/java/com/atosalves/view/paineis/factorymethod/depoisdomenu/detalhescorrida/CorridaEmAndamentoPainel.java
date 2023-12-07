package com.atosalves.view.paineis.factorymethod.depoisdomenu.detalhescorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.factorymethod.PainelTemplate;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridaEmAndamentoPainel extends PainelTemplate {

	private LoginDTO loginDTO;
	private Long idCorrida;

	private GerenciadorDeCorrida gerenciadorDeCorrida;

	public CorridaEmAndamentoPainel(LoginDTO loginDTO, Long idCorrida) {
		this.loginDTO = loginDTO;
		this.idCorrida = idCorrida;
		this.gerenciadorDeCorrida = new GerenciadorDeCorrida();
	}

	private void finalizarBotao() {
		try {
			gerenciadorDeCorrida.finalizarCorrida(idCorrida);
			painel.setPainel(new MenuPainel(loginDTO).criarPainel());
		} catch (Exception e) {
			new JanelaDeErro(e);
		}
	}

	private void cancelarBotao() {
		try {
			gerenciadorDeCorrida.cancelarCorrida(loginDTO, idCorrida);
			painel.setPainel(new MenuPainel(loginDTO).criarPainel());
		} catch (Exception e) {
			new JanelaDeErro(e);
		}
	}

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		painel =
			new PainelBuilderImpl()
				.setTexto("CORRIDA EM ANDAMENTO", Tema.FONTE_MUITO_FORTE)
				.setBotao("FINALIZAR", this::finalizarBotao)
				.setBotao("CANCELAR", this::cancelarBotao)
				.construir();
	}
}
