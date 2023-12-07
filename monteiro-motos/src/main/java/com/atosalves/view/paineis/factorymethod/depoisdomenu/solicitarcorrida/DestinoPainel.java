package com.atosalves.view.paineis.factorymethod.depoisdomenu.solicitarcorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.corrida.EnderecoViewDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.model.exceptions.AcessoNegadoException;
import com.atosalves.model.exceptions.SaldoInsuficienteExceptions;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.exception.CampoInvalidoException;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.factorymethod.PainelTemplate;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DestinoPainel extends PainelTemplate {

	private TextoCaixa enderecoCaixa;
	private TextoCaixa bairroCaixa;
	private TextoCaixa ruaCaixa;
	private TextoCaixa cepCaixa;

	private EnderecoViewDTO pontoDeEncontro;
	private EnderecoViewDTO destino;
	private LoginDTO loginDTO;

	public DestinoPainel(LoginDTO loginDTO, EnderecoViewDTO pontoDeEncontro) {
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
			destino = getDados();
			GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
			idCorrida = gerenciadorDeCorrida.solicitarCorrida(loginDTO, pontoDeEncontro, destino);
			painel.setPainel(new CorridaEmEsperaPainel(loginDTO, idCorrida).criarPainel());
		} catch (AcessoNegadoException acessoNegado) {
			idCorrida = acessoNegado.getIdCorrida();
			painel.setPainel(new CorridaEmEsperaPainel(loginDTO, idCorrida).criarPainel());
			new JanelaDeErro(acessoNegado);
		} catch (CampoInvalidoException campoInvalido) {
			new JanelaDeErro(campoInvalido);
		} catch (SaldoInsuficienteExceptions saldoInsuficiente) {
			new JanelaDeErro(saldoInsuficiente);
		}
	}

	private void voltarBotao() {
		painel.setPainel(new PontoDeEncontroPainel(loginDTO).criarPainel());
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
		painel =
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
}
