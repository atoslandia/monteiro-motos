package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.model.Endereco;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class PontoDeEncontroCreator implements PainelCreator {

	private Painel solicitarCorridas;

	private TextoCaixa enderecoCaixa;
	private TextoCaixa bairroCaixa;
	private TextoCaixa ruaCaixa;
	private TextoCaixa cepCaixa;

	// TODO: mudar para DTO
	public Endereco getDados() {
		return new Endereco(
			enderecoCaixa.pegarCampo(),
			bairroCaixa.pegarCampo(),
			ruaCaixa.pegarCampo(),
			cepCaixa.pegarCampo()
		);
	}

	private void confirmarBotao() {
		solicitarCorridas.setPainel(new DestinoPainelCreator(getDados()).criarPainel());
	}

	private void voltarBotao() {
		solicitarCorridas.setPainel(new MenuPainelCreator().criarPainel());
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
		solicitarCorridas =
			new PainelBuilderImpl()
				.setTexto("PONTO DE ENCONTRO", Tema.FONTE_MUITO_FORTE)
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
		return solicitarCorridas;
	}
}
