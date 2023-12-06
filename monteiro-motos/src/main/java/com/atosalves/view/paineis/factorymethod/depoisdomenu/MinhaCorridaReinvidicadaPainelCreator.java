package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.controller.exceptions.NenhumaCorridaEncontradaException;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.ListaDeCorridas;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.detalhescorrida.CorridaEmAndamentoPainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class MinhaCorridaReinvidicadaPainelCreator implements PainelCreator {

	private Painel minhaCorridaReinvidicadaPainel;

	private ListaDeCorridas listaDeCorridas;

	private LoginDTO loginDTO;

	public MinhaCorridaReinvidicadaPainelCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void abrirCorrida() {
		minhaCorridaReinvidicadaPainel.setPainel(
			new CorridaEmAndamentoPainelCreator(loginDTO, listaDeCorridas.pegarSelecionado()).criarPainel()
		);
	}

	private void voltarBotao() {
		minhaCorridaReinvidicadaPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		listaDeCorridas = COMPONENTES_FACTORY.criarListaDeItems(corridaReinvidicadaLista());
	}

	private CorridaDTO[] corridaReinvidicadaLista() {
		CorridaDTO[] corrida = new CorridaDTO[0];
		try {
			GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
			corrida = gerenciadorDeCorrida.buscarCorridaReinvidicada(loginDTO);
		} catch (NenhumaCorridaEncontradaException e) {
			new JanelaDeErro(e);
		}
		return corrida;
	}

	@Override
	public void construirPainel() {
		minhaCorridaReinvidicadaPainel =
			new PainelBuilderImpl()
				.setTexto("CORRIDA REINVIDICADA", Tema.FONTE_MUITO_FORTE)
				.setListaDeItems(listaDeCorridas, this::abrirCorrida)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return minhaCorridaReinvidicadaPainel;
	}
}
