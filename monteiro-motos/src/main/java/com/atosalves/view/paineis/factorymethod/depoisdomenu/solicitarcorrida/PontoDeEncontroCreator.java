package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.dto.EnderecoViewDTO;
import com.atosalves.dto.LoginDTO;
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

	private LoginDTO loginDTO;

	public PontoDeEncontroCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public EnderecoViewDTO getPontoEndereco() {
		return new EnderecoViewDTO(bairroCaixa.pegarCampo(), ruaCaixa.pegarCampo(), cepCaixa.pegarCampo());
	}

	private void confirmarBotao() {
		solicitarCorridas.setPainel(new DestinoPainelCreator(loginDTO, getPontoEndereco()).criarPainel());
	}

	private void voltarBotao() {
		solicitarCorridas.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
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
