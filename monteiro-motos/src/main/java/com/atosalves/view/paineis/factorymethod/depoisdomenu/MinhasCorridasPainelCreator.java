package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.ListaDeCorridas;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.detalhescorrida.DetalhadorDeCorridaCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class MinhasCorridasPainelCreator implements PainelCreator {

	private Painel minhasCorridasPainel;

	private ListaDeCorridas listaDeCorridas;

	private LoginDTO loginDTO;

	public MinhasCorridasPainelCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void detalharCorrida() {
		minhasCorridasPainel.setPainel(new DetalhadorDeCorridaCreator(loginDTO, listaDeCorridas.pegarSelecionado()).criarPainel());
	}

	private CorridaDTO[] listarCorridas() {
		GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
		return gerenciadorDeCorrida.buscarHistoricoDeCorridas(loginDTO);
	}

	private void voltarBotao() {
		minhasCorridasPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		listaDeCorridas = COMPONENTES_FACTORY.criarListaDeItems(listarCorridas());
	}

	@Override
	public void construirPainel() {
		minhasCorridasPainel =
			new PainelBuilderImpl()
				.setTexto("MINHAS CORRIDAS", Tema.FONTE_MUITO_FORTE)
				.setListaDeItems(listaDeCorridas, this::detalharCorrida)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return minhasCorridasPainel;
	}
}
