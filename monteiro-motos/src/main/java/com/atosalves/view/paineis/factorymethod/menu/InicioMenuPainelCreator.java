package com.atosalves.view.paineis.factorymethod.menu;

import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.DepositarSaldoCreator;
import com.atosalves.view.paineis.factorymethod.depoisdomenu.ExtratoPainelCreator;
import com.atosalves.view.paineis.factorymethod.inicio.LoginPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class InicioMenuPainelCreator implements PainelCreator {

	private Painel inicioMenuPainel;

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		inicioMenuPainel =
			new PainelBuilderImpl()
				.setTexto("BEM VINDO(A)", Tema.FONTE_MUITO_FORTE)
				// TODO: se for passageiro
				.setBotao("SOLICITAR CORRIDA")
				.setBotao(
					"DEPOSITAR",
					() -> {
						inicioMenuPainel.setPainel(new DepositarSaldoCreator().criarPainel());
					}
				)
				.setBotao(
					"EXTRATO",
					() -> {
						inicioMenuPainel.setPainel(new ExtratoPainelCreator().criarPainel());
					}
				)
				// menu
				.setBotaoMenu("INICIO")
				.setBotaoMenu(
					"CORRIDAS",
					() -> {
						inicioMenuPainel.setPainel(new CorridasMenuPainelCreator().criarPainel());
					}
				)
				.setBotaoMenu(
					"EDITAR",
					() -> {
						inicioMenuPainel.setPainel(new EditarMenuPainelCreator().criarPainel());
					}
				)
				.setBotao(
					"SAIR",
					() -> {
						inicioMenuPainel.setPainel(new LoginPainelCreator().criarPainel());
					}
				)
				.construir();

		inicioMenuPainel.getBotao("INICIO").setBounds(0, 300, 200, 80);
		inicioMenuPainel.getBotao("INICIO").setEnabled(false);

		inicioMenuPainel.getBotao("CORRIDAS").setBounds(199, 300, 345, 80);
		inicioMenuPainel.getBotao("EDITAR").setBounds(543, 300, 210, 80);

		inicioMenuPainel.getBotao("SAIR").setBounds(630, 10, 100, 35);
	}

	@Override
	public Painel factoryMethod() {
		return inicioMenuPainel;
	}
}
