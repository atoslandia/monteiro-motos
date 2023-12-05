package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.LoginDTO;
import com.atosalves.model.exceptions.AcessoNegadoException;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridaEmEsperaPainelCreator implements PainelCreator {

	private Painel corridaEmEsperaPainel;

	private LoginDTO loginDTO;
	private Long idCorrida;

	public CorridaEmEsperaPainelCreator(LoginDTO loginDTO, Long idCorrida) {
		this.loginDTO = loginDTO;
		this.idCorrida = idCorrida;
	}

	private void cancelarCorridaBotao() {
		try {
			GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
			gerenciadorDeCorrida.cancelarCorrida(loginDTO, idCorrida);
			corridaEmEsperaPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
		} catch (AcessoNegadoException e) {
			new JanelaDeErro(e.getMessage());
		}
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
