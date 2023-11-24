package com.atosalves.view.paineis.menu;

import com.atosalves.view.builder.PainelBuilderImpl;
import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.inicio.LoginPainel;
import com.atosalves.view.util.Tema;

public class CorridasMenuPainel extends PainelPadrao {

	private Botao inicioMenu;
	private Botao corridasMenu;
	private Botao editarMenu;
	private Botao sair;

	public CorridasMenuPainel() {
		corridasMenu.setBounds(199, 300, 345, 80);
		corridasMenu.setEnabled(false);

		inicioMenu.setBounds(0, 300, 200, 80);
		editarMenu.setBounds(543, 300, 210, 80);

		sair.setBounds(630, 10, 100, 35);

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
	protected void inicializarComponentes(ComponentesFactory fabrica) {
		this.inicioMenu = fabrica.criarBotaoMenu("INICIO");
		this.corridasMenu = fabrica.criarBotaoMenu("CORRIDAS");
		this.editarMenu = fabrica.criarBotaoMenu("EDITAR");

		this.sair = fabrica.criarBotao("SAIR");
	}

	@Override
	protected PainelPadrao montarComponentes(PainelBuilderImpl construtor) {
		return construtor
			.setTexto("CORRIDAS", Tema.FONTE_MUITO_FORTE)
			.setBotao(inicioMenu)
			.setBotao(corridasMenu)
			.setBotao(editarMenu)
			.setBotao(sair)
			.construir();
	}
}
