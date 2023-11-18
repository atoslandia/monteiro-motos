package com.atosalves.view.paineis.menu;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.inicio.LoginPainel;

public class EditarMenuPainel extends PainelPadrao {

	private Botao editar;

	private Botao inicioMenu;
	private Botao corridasMenu;
	private Botao editarMenu;

	private Botao sair;

	public EditarMenuPainel() {
		corridasMenu();
		inicioMenu();
		sair();
	}

	private void corridasMenu() {
		corridasMenu.aoClicar(() -> setPainel(new CorridasMenuPainel()));
	}

	private void inicioMenu() {
		inicioMenu.aoClicar(() -> setPainel(new InicioMenuPainel()));
	}

	private void sair() {
		sair.aoClicar(() -> setPainel(new LoginPainel()));
	}

	@Override
	protected void construirComponentes() {
		this.editar = fabrica.criarBotao();

		this.inicioMenu = fabrica.criarBotaoMenu();
		this.corridasMenu = fabrica.criarBotaoMenu();
		this.editarMenu = fabrica.criarBotaoMenu();

		this.sair = fabrica.criarBotao();

		construtor
			.botao("EDITAR PERFIL", editar)
			.botao("INICIO", inicioMenu)
			.botao("CORRIDAS", corridasMenu)
			.botao("EDITAR", editarMenu)
			.botao("SAIR", sair)
			.construir();

		inicioMenu.setBounds(0, 300, 200, 80);
		corridasMenu.setBounds(199, 300, 345, 80);

		editarMenu.setBounds(543, 300, 210, 80);
		editarMenu.setEnabled(false);

		sair.setLocation(650, 10);
	}
}
