package com.atosalves.view.paineis.factorymethod.menu;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.view.componentes.ListaDeCorridas;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.DepositarSaldoCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.DetalhadorDeCorridaCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.ExtratoPainelCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida.PontoDeEncontroCreator;
import com.atosalves.view.paineis.factorymethod.inicio.LoginPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class MenuPainelCreator implements PainelCreator {

	private Painel menuPainel;

	private Painel inicioPainel;
	private Painel corridasPainel;
	private Painel editarPainel;

	private ListaDeCorridas listaDeItems;

	private LoginDTO loginDTO;

	public MenuPainelCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void solicitarCorridaBotao() {
		menuPainel.setPainel(new PontoDeEncontroCreator(loginDTO).criarPainel());
	}

	private void depositarBotao() {
		menuPainel.setPainel(new DepositarSaldoCreator(loginDTO).criarPainel());
	}

	private void extratoBotao() {
		menuPainel.setPainel(new ExtratoPainelCreator(loginDTO).criarPainel());
	}

	private void listaCorrida() {
		menuPainel.setPainel(
			new DetalhadorDeCorridaCreator(listaDeItems.pegarSelecionado(), loginDTO).criarPainel()
		);
	}

	private CorridaDTO[] getListaDeCorridas() {
		GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
		if (loginDTO.tipoUsuario().equals(TipoUsuario.PASSAGEIRO)) {
			return gerenciadorDeCorrida.buscarHistoricoDeCorridas(loginDTO);
		}
		return gerenciadorDeCorrida.buscarCorridasPendentes();
	}

	@Override
	public void inicializarComponentes() {
		listaDeItems = COMPONENTES_FACTORY.criarListaDeItems(getListaDeCorridas());
	}

	@Override
	public void construirPainel() {
		inicioPainel();
		corridasPainel();
		editarPainel();

		menuPainel =
			new PainelBuilderImpl()
				.addPainel(inicioPainel)
				.addPainel(corridasPainel)
				.addPainel(editarPainel)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return menuPainel;
	}

	private void inicioPainel() {
		inicioPainel =
			new PainelBuilderImpl()
				.setTexto("BEM VINDO(A)", Tema.FONTE_MUITO_FORTE)
				.setBotao("SOLICITAR CORRIDA", this::solicitarCorridaBotao)
				.setBotao("DEPOSITAR", this::depositarBotao)
				.setBotao("EXTRATO", this::extratoBotao)
				.setBotaoMenu("INICIO", this::inicioBotao, false)
				.setBotaoMenu("CORRIDAS", this::corridasBotao, true)
				.setBotaoMenu("PERFIL", this::editarBotao, true)
				.construir();
	}

	private void corridasPainel() {
		corridasPainel =
			new PainelBuilderImpl()
				.setTexto("CORRIDAS", Tema.FONTE_MUITO_FORTE)
				.setListaDeItems(listaDeItems, this::listaCorrida)
				.setBotaoMenu("INICIO", this::inicioBotao, true)
				.setBotaoMenu("CORRIDAS", this::corridasBotao, false)
				.setBotaoMenu("PERFIL", this::editarBotao, true)
				.construir();
	}

	private void editarPainel() {
		editarPainel =
			new PainelBuilderImpl()
				.setTexto("EDITAR PERFIL", Tema.FONTE_MUITO_FORTE)
				.setBotaoMenu("INICIO", this::inicioBotao, true)
				.setBotaoMenu("CORRIDAS", this::corridasBotao, true)
				.setBotaoMenu("PERFIL", this::editarBotao, false)
				.setBotao("SAIR", this::sairBotao)
				.construir();

		editarPainel.getBotao("SAIR").setBounds(630, 10, 100, 35);
	}

	private void sairBotao() {
		menuPainel.setPainel(new LoginPainelCreator().criarPainel());
	}

	private void inicioBotao() {
		inicioPainel.setVisible(true);
		corridasPainel.setVisible(false);
		editarPainel.setVisible(false);
		menuPainel.repaint();
	}

	private void corridasBotao() {
		inicioPainel.setVisible(false);
		corridasPainel.setVisible(true);
		editarPainel.setVisible(false);
		menuPainel.repaint();
	}

	private void editarBotao() {
		inicioPainel.setVisible(false);
		corridasPainel.setVisible(false);
		editarPainel.setVisible(true);
		menuPainel.repaint();
	}
}
