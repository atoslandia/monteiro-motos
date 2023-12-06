package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class ExtratoPainelCreator implements PainelCreator {

	private Painel extratoPainel;

	private LoginDTO loginDTO;

	private String saldo;

	public ExtratoPainelCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
		this.saldo = Float.toString(new UsuarioController().consultarSaldo(loginDTO)) + " R$";
	}

	private void voltarBotao() {
		extratoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	private void enviarHistorico() {
		// TODO: fazer enviar histórico
	}

	@Override
	public void construirPainel() {
		extratoPainel =
			new PainelBuilderImpl()
				.setTexto("EXTRATO", Tema.FONTE_MUITO_FORTE)
				.setTexto(saldo, Tema.FONTE_FORTE)
				.setBotao("ENVIAR HISTÓRICO", this::enviarHistorico)
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
