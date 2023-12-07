package com.atosalves.view.paineis.painelmethod.depoisdomenu.solicitarcorrida;

import com.atosalves.dto.corrida.EnderecoViewDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.exception.CampoInvalidoException;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.paineis.painelmethod.PainelTemplate;
import com.atosalves.view.paineis.painelmethod.menu.MenuPainel;
import com.atosalves.view.util.Tema;

public class PontoDeEncontroPainel extends PainelTemplate {

	private TextoCaixa bairroCaixa;
	private TextoCaixa ruaCaixa;
	private TextoCaixa cepCaixa;

	private LoginDTO loginDTO;

	public PontoDeEncontroPainel(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public EnderecoViewDTO getPontoEndereco() throws CampoInvalidoException {
		return new EnderecoViewDTO(bairroCaixa.pegarCampo(), ruaCaixa.pegarCampo(), cepCaixa.pegarCampo());
	}

	private void confirmarBotao() {
		try {
			painel.setPainel(new DestinoPainel(loginDTO, getPontoEndereco()).criarPainel());
		} catch (Exception e) {
			new JanelaDeErro(e);
		}
	}

	private void voltarBotao() {
		painel.setPainel(new MenuPainel(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		bairroCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		ruaCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		cepCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
	}

	@Override
	public void construirPainel() {
		painel =
			new PainelBuilderImpl()
				.setTexto("PONTO DE ENCONTRO", Tema.FONTE_MUITO_FORTE)
				.setTextoCaixa("BAIRRO", bairroCaixa)
				.setTextoCaixa("RUA", ruaCaixa)
				.setTextoCaixa("CEP", cepCaixa)
				.setBotao("CONFIRMAR", this::confirmarBotao)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}
}
