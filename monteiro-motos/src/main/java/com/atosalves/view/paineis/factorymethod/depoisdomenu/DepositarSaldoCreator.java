package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DepositarSaldoCreator implements PainelCreator {

	private TextoCaixa valor;

	private Painel depositarSaldoPainel;

	private LoginDTO loginDTO;

	public DepositarSaldoCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void depositarBotao() {
		// TODO: usar controller para depositar valor
	}

	private void voltarBotao() {
		depositarSaldoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		this.valor = COMPONENTES_FACTORY.criarCaixaTexto();
	}

	@Override
	public void construirPainel() {
		depositarSaldoPainel =
			new PainelBuilderImpl()
				.setTexto("DEPOSITAR SALDO", Tema.FONTE_MUITO_FORTE)
				.setTextoCaixa("VALOR", valor)
				.setBotao("DEPOSITAR", this::depositarBotao)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return depositarSaldoPainel;
	}
}
