package com.atosalves.view.paineis.factorymethod.menu;

import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.inicio.LoginPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class EditarMenuPainelCreator implements PainelCreator {

	private Painel editarMenuPainel;

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		editarMenuPainel =
			new PainelBuilderImpl()
				.setTexto("EDITAR PERFIL", Tema.FONTE_MUITO_FORTE)
				.setBotaoMenu(
					"INICIO",
					() -> {
						editarMenuPainel.setPainel(new InicioMenuPainelCreator().criarPainel());
					}
				)
				.setBotaoMenu(
					"CORRIDAS",
					() -> {
						editarMenuPainel.setPainel(new CorridasMenuPainelCreator().criarPainel());
					}
				)
				.setBotaoMenu("EDITAR")
				.setBotao(
					"SAIR",
					() -> {
						editarMenuPainel.setPainel(new LoginPainelCreator().criarPainel());
					}
				)
				.construir();

		editarMenuPainel.getBotao("INICIO").setBounds(0, 300, 200, 80);
		editarMenuPainel.getBotao("CORRIDAS").setBounds(199, 300, 345, 80);

		editarMenuPainel.getBotao("EDITAR").setBounds(543, 300, 210, 80);
		editarMenuPainel.getBotao("EDITAR").setEnabled(false);

		editarMenuPainel.getBotao("SAIR").setBounds(630, 10, 100, 35);
	}

	@Override
	public Painel factoryMethod() {
		return editarMenuPainel;
	}
}
