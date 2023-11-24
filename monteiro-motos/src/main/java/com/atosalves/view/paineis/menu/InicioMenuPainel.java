package com.atosalves.view.paineis.menu;

import com.atosalves.view.builder.PainelBuilderImpl;
import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.depoisdomenu.DepositarSaldo;
import com.atosalves.view.paineis.inicio.LoginPainel;
import com.atosalves.view.util.Tema;

public class InicioMenuPainel extends PainelPadrao {

	private Botao solicitarCorrida;
	private Botao depositar;
	private Botao caixa;

	private Botao inicioMenu;
	private Botao corridasMenu;
	private Botao editarMenu;

	private Botao sair;

	public InicioMenuPainel() {
		inicioMenu.setBounds(0, 300, 200, 80);
		inicioMenu.setEnabled(false);

		corridasMenu.setBounds(199, 300, 345, 80);
		editarMenu.setBounds(543, 300, 210, 80);

		sair.setBounds(630, 10, 100, 35);

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
	protected void inicializarComponentes(ComponentesFactory fabrica) {
		this.solicitarCorrida = fabrica.criarBotao("SOLICITAR CORRIDA");
		this.depositar = fabrica.criarBotao("DEPOSITAR");
		this.caixa = fabrica.criarBotao("HISTÓRICO DE COMPRAS");

		this.inicioMenu = fabrica.criarBotaoMenu("INICIO");
		this.corridasMenu = fabrica.criarBotaoMenu("CORRIDAS");
		this.editarMenu = fabrica.criarBotaoMenu("EDITAR");

		this.sair = fabrica.criarBotao("SAIR");
	}

	@Override
	protected PainelPadrao montarComponentes(PainelBuilderImpl construtor) {
		return construtor
			.setTexto("BEM VINDO(A)", Tema.FONTE_MUITO_FORTE)
			// TODO: se for passageiro
			.setBotao(solicitarCorrida)
			.setBotao(depositar)
			.setBotao(caixa)
			// menu
			.setBotao(inicioMenu)
			.setBotao(corridasMenu)
			.setBotao(editarMenu)
			.setBotao(sair)
			.construir();
	}
}
