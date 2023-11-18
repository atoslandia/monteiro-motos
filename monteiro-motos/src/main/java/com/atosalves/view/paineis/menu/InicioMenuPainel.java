package com.atosalves.view.paineis.menu;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.depoisdomenu.DepositarSaldo;
import com.atosalves.view.paineis.inicio.LoginPainel;
import com.atosalves.view.util.Tema;

public class InicioMenuPainel extends PainelPadrao {

	private Botao solicitarCorrida;
	private Botao depositar;
	private Botao usuarios;
	private Botao valorCredito;
	private Botao caixa;

	private Botao inicioMenu;
	private Botao corridasMenu;
	private Botao editarMenu;

	private Botao sair;

	public InicioMenuPainel() {
		botaoDepositar();
		corridasMenu();
		editarMenu();
		sair();
	}

	private void botaoDepositar() {
		depositar.aoClicar(() -> {
			setPainel(new DepositarSaldo());
		});
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
		this.depositar = fabrica.criarBotao();
		this.usuarios = fabrica.criarBotao();
		this.valorCredito = fabrica.criarBotao();
		this.caixa = fabrica.criarBotao();

		this.inicioMenu = fabrica.criarBotaoMenu();
		this.corridasMenu = fabrica.criarBotaoMenu();
		this.editarMenu = fabrica.criarBotaoMenu();

		this.sair = fabrica.criarBotao();

		construtor
			.texto("BEM VINDO(A)", Tema.FONTE_MUITO_FORTE)
			// TODO: se for passageiro
			.botao("SOLICITAR CORRIDA", solicitarCorrida)
			.botao("DEPOSITAR SALDO", depositar)
			// TODO: se for adminastro
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
