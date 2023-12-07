package com.atosalves.view.paineis.painelmethod.depoisdomenu;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.corrida.CorridaDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.view.componentes.ListaDeCorridas;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.paineis.painelmethod.PainelTemplate;
import com.atosalves.view.paineis.painelmethod.depoisdomenu.detalhescorrida.DetalhadorDeCorridaPainel;
import com.atosalves.view.paineis.painelmethod.menu.MenuPainel;
import com.atosalves.view.util.Tema;

public class CorridasPendentesPainel extends PainelTemplate {

	private ListaDeCorridas listaDeCorridas;
	private LoginDTO loginDTO;

	public CorridasPendentesPainel(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void detalharCorrida() {
		painel.setPainel(new DetalhadorDeCorridaPainel(loginDTO, listaDeCorridas.pegarSelecionado()).criarPainel());
	}

	private void voltarBotao() {
		painel.setPainel(new MenuPainel(loginDTO).criarPainel());
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
		painel =
			new PainelBuilderImpl()
				.setTexto("INICIAR CORRIDA", Tema.FONTE_MUITO_FORTE)
				.setListaDeItems(listaDeCorridas, this::detalharCorrida)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}
}
