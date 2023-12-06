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

public class CorridasPendentesPainelCreator implements PainelCreator {

	private Painel corridasPendentesPainel;

	private ListaDeCorridas listaDeCorridas;

	private LoginDTO loginDTO;

	public CorridasPendentesPainelCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void detalharCorrida() {
		corridasPendentesPainel.setPainel(new DetalhadorDeCorridaCreator(loginDTO, listaDeCorridas.pegarSelecionado()).criarPainel());
	}

	private void voltarBotao() {
		corridasPendentesPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		listaDeCorridas = COMPONENTES_FACTORY.criarListaDeItems(listarCorridas());
	}

	private CorridaDTO[] listarCorridas() {
		GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
		return gerenciadorDeCorrida.buscarCorridasPendentes();
	}

	@Override
	public void construirPainel() {
		corridasPendentesPainel =
			new PainelBuilderImpl()
				.setTexto("INICIAR CORRIDA", Tema.FONTE_MUITO_FORTE)
				.setListaDeItems(listaDeCorridas, this::detalharCorrida)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return corridasPendentesPainel;
	}
}
