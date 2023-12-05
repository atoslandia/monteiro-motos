package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.controller.exceptions.SolicitarCorridaException;
import com.atosalves.dto.EnderecoViewDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.exception.CampoInvalidoException;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DestinoPainelCreator implements PainelCreator {

	private Painel destinoPainel;

	private TextoCaixa enderecoCaixa;
	private TextoCaixa bairroCaixa;
	private TextoCaixa ruaCaixa;
	private TextoCaixa cepCaixa;

	private EnderecoViewDTO pontoDeEncontro;
	private LoginDTO loginDTO;

	public DestinoPainelCreator(LoginDTO loginDTO, EnderecoViewDTO pontoDeEncontro) {
		this.pontoDeEncontro = pontoDeEncontro;
		this.loginDTO = loginDTO;
	}

	private EnderecoViewDTO getDados() throws CampoInvalidoException {
		String bairro = bairroCaixa.pegarCampo();
		String rua = ruaCaixa.pegarCampo();
		String cep = cepCaixa.pegarCampo();
		EnderecoViewDTO dto = new EnderecoViewDTO(bairro, rua, cep);
		return dto;
	}

	private void solicitarBotao() {
		Long idCorrida = null;
		try {
			EnderecoViewDTO destino = getDados();

			GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
			idCorrida = gerenciadorDeCorrida.solicitarCorrida(loginDTO, pontoDeEncontro, destino);
		} catch (SolicitarCorridaException e) {
			idCorrida = e.getIdCorrida();
			new JanelaDeErro(e.getMessage());
		} catch (Exception e1) {
			new JanelaDeErro(e1.getMessage());
		} finally {
			destinoPainel.setPainel(new CorridaEmEsperaPainelCreator(loginDTO, idCorrida).criarPainel());
		}
	}

	private void voltarBotao() {
		destinoPainel.setPainel(new PontoDeEncontroCreator(loginDTO).criarPainel());
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
				.setBotao("SOLICITAR", this::solicitarBotao)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return destinoPainel;
	}
}
