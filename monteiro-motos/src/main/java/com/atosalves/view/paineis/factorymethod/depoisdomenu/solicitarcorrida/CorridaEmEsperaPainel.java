package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.LoginDTO;
import com.atosalves.model.exceptions.AcessoNegadoException;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.factorymethod.PainelTemplate;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridaEmEsperaPainel extends PainelTemplate {

	private LoginDTO loginDTO;
	private Long idCorrida;

	public CorridaEmEsperaPainel(LoginDTO loginDTO, Long idCorrida) {
		this.loginDTO = loginDTO;
		this.idCorrida = idCorrida;
	}

	private void cancelarCorridaBotao() {
		try {
			GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
			gerenciadorDeCorrida.cancelarCorrida(loginDTO, idCorrida);
			painel.setPainel(new MenuPainel(loginDTO).criarPainel());
		} catch (AcessoNegadoException e) {
			new JanelaDeErro(e);
		}
	}

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		painel =
			new PainelBuilderImpl()
				.setTexto("CORRIDA EM ESPERA", Tema.FONTE_MUITO_FORTE)
				.setBotao("CANCELAR CORRIDA", this::cancelarCorridaBotao)
				.construir();
	}
}
