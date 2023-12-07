package com.atosalves.view.paineis.painelmethod.depoisdomenu.detalhescorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.corrida.CorridaDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.exceptions.AcessoNegadoException;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.painelbuilder.PainelBuilder;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.paineis.painelmethod.PainelTemplate;
import com.atosalves.view.paineis.painelmethod.menu.MenuPainel;
import com.atosalves.view.util.Tema;
import javax.swing.JOptionPane;

public class DetalhadorDeCorridaPainel extends PainelTemplate {

	private Long idCorrida;
	private LoginDTO loginDTO;

	public DetalhadorDeCorridaPainel(LoginDTO loginDTO, Long idCorrida) {
		this.idCorrida = idCorrida;
		this.loginDTO = loginDTO;
	}

	private void reinvidicarBotao() {
		try {
			GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
			gerenciadorDeCorrida.reivindicarCorrida(loginDTO, idCorrida);

			painel.setPainel(new CorridaEmAndamentoPainel(loginDTO, idCorrida).criarPainel());
		} catch (Exception e) {
			new JanelaDeErro(e);
		}
	}

	private void voltarBotao() {
		painel.setPainel(new MenuPainel(loginDTO).criarPainel());
	}

	private String detalhamentoCorrida() {
		GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
		CorridaDTO corridaDTO = gerenciadorDeCorrida.buscarCorridaPeloId(idCorrida);
		return (
			"<html>" +
			"ID: " +
			corridaDTO.corrida().getId() +
			"<br/>PASSAGEIRO: " +
			corridaDTO.corrida().getPassageiro() +
			"<br/>PONTO DE ENCONTRO: " +
			corridaDTO.corrida().getPontoDeEncontro() +
			"<br/>DESTINO: " +
			corridaDTO.corrida().getDestino() +
			"</html>"
		);
	}

	private void avaliarCorridaBotao() {
		new JOptionPane();
		int nota =
			JOptionPane.showOptionDialog(
				null,
				"AVALIE O MOTOTAXISTA",
				"AVALIAÇÃO",
				0,
				0,
				Tema.AVALIACAO_ICONE,
				new Object[] { 1, 2, 3, 4, 5 },
				null
			) +
			1;

		try {
			GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
			gerenciadorDeCorrida.avaliarMototaxista(idCorrida, nota);
		} catch (AcessoNegadoException e) {
			new JanelaDeErro(e);
		}
	}

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		PainelBuilder builder = new PainelBuilderImpl()
			.setTexto("DETALHES DA CORRIDA", Tema.FONTE_MUITO_FORTE)
			.setMuitoTexto(detalhamentoCorrida());

		if (loginDTO.tipoUsuario().equals(TipoUsuario.MOTOTAXISTA)) {
			builder.setBotao("REINVINDICAR", this::reinvidicarBotao);
		} else {
			builder.setBotao("AVALIAR MOTOTAXISTA", this::avaliarCorridaBotao);
		}

		painel = builder.setBotao("VOLTAR", this::voltarBotao).construir();
	}
}
