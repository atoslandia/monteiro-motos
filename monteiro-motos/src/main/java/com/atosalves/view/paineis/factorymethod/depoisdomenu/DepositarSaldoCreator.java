package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.InicioMenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DepositarSaldoCreator implements PainelCreator {

	private TextoCaixa valor;

	private Painel depositarSaldoPainel;

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
				.setBotao("DEPOSITAR")
				.setBotao(
					"VOLTAR",
					() -> {
						depositarSaldoPainel.setPainel(new InicioMenuPainelCreator().criarPainel());
					}
				)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return depositarSaldoPainel;
	}
}
