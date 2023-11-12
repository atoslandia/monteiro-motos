package com.atosalves.view.paineis.menu;

import com.atosalves.view.componentes.BotaoComponente;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.inicio.LoginPainel;
import com.atosalves.view.util.Tema;

public class InicioMenuPainel extends PainelPadrao {

	private BotaoComponente solicitarCorrida;
	private BotaoComponente compraCredito;
	private BotaoComponente usuarios;
	private BotaoComponente valorCredito;
	private BotaoComponente caixa;

	private BotaoComponente inicioMenu;
	private BotaoComponente corridasMenu;
	private BotaoComponente editarMenu;

	private BotaoComponente sair;

	public InicioMenuPainel() {
		corridasMenu();
		editarMenu();
		sair();
	}

	private void corridasMenu() {
		corridasMenu.aoClicar(() -> setPainel(new CorridasMenuPainel()));
	}

	private void editarMenu() {
		editarMenu.aoClicar(() -> setPainel(new EditarMenuPainel()));
	}

	private void sair() {
		sair.aoClicar(() -> setPainel(new LoginPainel()));
	}

	@Override
	protected void construirComponentes() {
		this.solicitarCorrida = fabrica.criarBotao();
		this.compraCredito = fabrica.criarBotao();
		this.usuarios = fabrica.criarBotao();
		this.valorCredito = fabrica.criarBotao();
		this.caixa = fabrica.criarBotao();

		this.inicioMenu = fabrica.criarBotaoMenu();
		this.corridasMenu = fabrica.criarBotaoMenu();
		this.editarMenu = fabrica.criarBotaoMenu();

		this.sair = fabrica.criarBotao();

		construtor
			.texto("BEM VINDO(A)", Tema.FONTE_MUITO_FORTE)
			// TODO se for passageiro
			.botao("SOLICITAR CORRIDA", solicitarCorrida)
			.botao("COMPRAR CRÉDITOS", compraCredito)
			// TODO se for adminastro
			.botao("LISTAR TODOS OS USUÁRIOS", usuarios)
			.botao("DEFINIR VALOR DE CRÉTIDO DE REINVIDICAÇÃO", valorCredito)
			.botao("DADOS DO CAIXA", caixa)
			// menu
			.botao("INICIO", inicioMenu)
			.botao("CORRIDAS", corridasMenu)
			.botao("EDITAR", editarMenu)
			.botao("SAIR", sair)
			.construir();

		inicioMenu.setBounds(0, 300, 200, 80);
		inicioMenu.setEnabled(false);

		corridasMenu.setBounds(199, 300, 345, 80);
		editarMenu.setBounds(543, 300, 210, 80);

		sair.setLocation(650, 10);
	}
}
