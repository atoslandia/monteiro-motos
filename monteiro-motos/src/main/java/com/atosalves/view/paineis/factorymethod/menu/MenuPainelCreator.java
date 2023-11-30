package com.atosalves.view.paineis.factorymethod.menu;

import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.DepositarSaldoCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.ExtratoPainelCreator;
import com.atosalves.view.paineis.factorymethod.inicio.LoginPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class MenuPainelCreator implements PainelCreator {

	private Painel menuPainel;

	private Painel inicioPainel;
	private Painel corridasPainel;
	private Painel editarPainel;

	private void solicitarCorridaBotao() {
		System.out.println();
	}

	private void depositarBotao() {
		menuPainel.setPainel(new DepositarSaldoCreator().criarPainel());
	}

	private void extratoBotao() {
		menuPainel.setPainel(new ExtratoPainelCreator().criarPainel());
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

	private void sairBotao() {
		menuPainel.setPainel(new LoginPainelCreator().criarPainel());
	}

	@Override
	public void inicializarComponentes() {}

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
				.setBotao("SAIR", this::sairBotao)
				.setBotaoMenu("INICIO", this::inicioBotao)
				.setBotaoMenu("CORRIDAS", this::corridasBotao)
				.setBotaoMenu("EDITAR", this::editarBotao)
				.construir();

		inicioPainel.getBotao("INICIO").setBounds(0, 300, 200, 80);
		inicioPainel.getBotao("INICIO").setEnabled(false);

		inicioPainel.getBotao("CORRIDAS").setBounds(199, 300, 345, 80);
		inicioPainel.getBotao("EDITAR").setBounds(543, 300, 210, 80);
		inicioPainel.getBotao("SAIR").setBounds(630, 10, 100, 35);
	}

	private void corridasPainel() {
		corridasPainel =
			new PainelBuilderImpl()
				.setTexto("CORRIDAS", Tema.FONTE_MUITO_FORTE)
				.setBotaoMenu("INICIO", this::inicioBotao)
				.setBotaoMenu("CORRIDAS", this::corridasBotao)
				.setBotaoMenu("EDITAR", this::editarBotao)
				.setBotao("SAIR", this::sairBotao)
				.construir();

		corridasPainel.getBotao("CORRIDAS").setBounds(199, 300, 345, 80);
		corridasPainel.getBotao("CORRIDAS").setEnabled(false);

		corridasPainel.getBotao("INICIO").setBounds(0, 300, 200, 80);
		corridasPainel.getBotao("EDITAR").setBounds(543, 300, 210, 80);

		corridasPainel.getBotao("SAIR").setBounds(630, 10, 100, 35);
	}

	private void editarPainel() {
		editarPainel =
			new PainelBuilderImpl()
				.setTexto("EDITAR PERFIL", Tema.FONTE_MUITO_FORTE)
				.setBotaoMenu("INICIO", this::inicioBotao)
				.setBotaoMenu("CORRIDAS", this::corridasBotao)
				.setBotaoMenu("EDITAR", this::editarBotao)
				.setBotao("SAIR", this::sairBotao)
				.construir();

		editarPainel.getBotao("INICIO").setBounds(0, 300, 200, 80);
		editarPainel.getBotao("CORRIDAS").setBounds(199, 300, 345, 80);

		editarPainel.getBotao("EDITAR").setBounds(543, 300, 210, 80);
		editarPainel.getBotao("EDITAR").setEnabled(false);

		editarPainel.getBotao("SAIR").setBounds(630, 10, 100, 35);
	}
}
