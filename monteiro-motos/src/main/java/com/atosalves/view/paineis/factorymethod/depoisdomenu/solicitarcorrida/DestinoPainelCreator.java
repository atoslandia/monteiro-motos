package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DestinoPainelCreator implements PainelCreator {

	private Painel destinoPainel;

	private TextoCaixa enderecoCaixa;
	private TextoCaixa bairroCaixa;
	private TextoCaixa ruaCaixa;
	private TextoCaixa cepCaixa;

	private void confirmarBotao() {
		destinoPainel.setPainel(new MenuPainelCreator().criarPainel());
	}

	private void voltarBotao() {
		destinoPainel.setPainel(new PontoDeEncontroCreator().criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		enderecoCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		bairroCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		ruaCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		cepCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
	}

	@Override
	public void construirPainel() {
		destinoPainel =
			new PainelBuilderImpl()
				.setTexto("DESTINO", Tema.FONTE_MUITO_FORTE)
				.setTextoCaixa("ENDEREÇO", enderecoCaixa)
				.setTextoCaixa("BAIRRO", bairroCaixa)
				.setTextoCaixa("RUA", ruaCaixa)
				.setTextoCaixa("CEP", cepCaixa)
				.setBotao("CONFIRMAR", this::confirmarBotao)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return destinoPainel;
	}
}
