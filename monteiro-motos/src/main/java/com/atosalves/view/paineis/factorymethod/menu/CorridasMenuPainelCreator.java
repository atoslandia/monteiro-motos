package com.atosalves.view.paineis.factorymethod.menu;

import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.inicio.LoginPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CorridasMenuPainelCreator implements PainelCreator {

	private Painel corridasMenuPainel;

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		corridasMenuPainel =
			new PainelBuilderImpl()
				.setTexto("CORRIDAS", Tema.FONTE_MUITO_FORTE)
				.setBotaoMenu(
					"INICIO",
					() -> {
						corridasMenuPainel.setPainel(new InicioMenuPainelCreator().criarPainel());
					}
				)
				.setBotaoMenu("CORRIDAS")
				.setBotaoMenu(
					"EDITAR",
					() -> {
						corridasMenuPainel.setPainel(new EditarMenuPainelCreator().criarPainel());
					}
				)
				.setBotao(
					"SAIR",
					() -> {
						corridasMenuPainel.setPainel(new LoginPainelCreator().criarPainel());
					}
				)
				.construir();

		corridasMenuPainel.getBotao("CORRIDAS").setBounds(199, 300, 345, 80);
		corridasMenuPainel.getBotao("CORRIDAS").setEnabled(false);

		corridasMenuPainel.getBotao("INICIO").setBounds(0, 300, 200, 80);
		corridasMenuPainel.getBotao("EDITAR").setBounds(543, 300, 210, 80);

		corridasMenuPainel.getBotao("SAIR").setBounds(630, 10, 100, 35);
	}

	@Override
	public Painel factoryMethod() {
		return corridasMenuPainel;
	}
}
