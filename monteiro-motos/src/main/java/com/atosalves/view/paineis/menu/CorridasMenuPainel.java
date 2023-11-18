package com.atosalves.view.paineis.menu;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.inicio.LoginPainel;
import com.atosalves.view.util.Tema;

public class CorridasMenuPainel extends PainelPadrao {

	private Botao inicioMenu;
	private Botao corridasMenu;
	private Botao editarMenu;
	private Botao sair;

	public CorridasMenuPainel() {
		inicioMenu();
		editarMenu();
		sair();
	}

	private void editarMenu() {
		editarMenu.aoClicar(() -> setPainel(new EditarMenuPainel()));
	}

	private void inicioMenu() {
		inicioMenu.aoClicar(() -> setPainel(new InicioMenuPainel()));
	}

	private void sair() {
		sair.aoClicar(() -> setPainel(new LoginPainel()));
	}

	@Override
	protected void construirComponentes() {
		this.inicioMenu = fabrica.criarBotaoMenu();
		this.corridasMenu = fabrica.criarBotaoMenu();
		this.editarMenu = fabrica.criarBotaoMenu();

		this.sair = fabrica.criarBotao();

		construtor
			.texto("CORRIDAS", Tema.FONTE_MUITO_FORTE)
			.botao("INICIO", inicioMenu)
			.botao("CORRIDAS", corridasMenu)
			.botao("EDITAR", editarMenu)
			.botao("SAIR", sair)
			.construir();

		corridasMenu.setBounds(199, 300, 345, 80);
		corridasMenu.setEnabled(false);

		inicioMenu.setBounds(0, 300, 200, 80);
		editarMenu.setBounds(543, 300, 210, 80);

		sair.setLocation(650, 10);
	}
}
