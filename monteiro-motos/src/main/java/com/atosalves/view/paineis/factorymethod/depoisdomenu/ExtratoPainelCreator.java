package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.dto.LoginDTO;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class ExtratoPainelCreator implements PainelCreator {

	private Painel extratoPainel;

	private LoginDTO loginDTO;

	public ExtratoPainelCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void voltarBotao() {
		extratoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	@Override
	public void construirPainel() {
		extratoPainel =
			new PainelBuilderImpl()
				.setTexto("EXTRATO", Tema.FONTE_MUITO_FORTE)
				// TODO: consultar controller para retornas uma lista com o extrato
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public void inicializarComponentes() {}

	@Override
	public Painel factoryMethod() {
		return extratoPainel;
	}
}
