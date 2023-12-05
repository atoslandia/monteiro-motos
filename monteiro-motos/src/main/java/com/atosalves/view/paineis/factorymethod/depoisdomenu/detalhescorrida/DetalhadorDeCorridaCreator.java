package com.atosalves.view.paineis.factorymethod.depoisdomenu.detalhescorrida;

import com.atosalves.controller.GerenciadorDeCorrida;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilder;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DetalhadorDeCorridaCreator implements PainelCreator {

	private Painel detalhadorDeCorrida;

	private Long idCorrida;
	private LoginDTO loginDTO;

	public DetalhadorDeCorridaCreator(LoginDTO loginDTO, Long idCorrida) {
		this.idCorrida = idCorrida;
		this.loginDTO = loginDTO;
	}

	private void reinvidicarBotao() {
		try {
			GerenciadorDeCorrida gerenciadorDeCorrida = new GerenciadorDeCorrida();
			gerenciadorDeCorrida.reivindicarCorrida(loginDTO, idCorrida);

			detalhadorDeCorrida.setPainel(new CorridaEmAndamentoPainelCreator(loginDTO, idCorrida).criarPainel());
		} catch (Exception e) {
			new JanelaDeErro(e);
		}
	}

	private void voltarBotao() {
		detalhadorDeCorrida.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
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

	@Override
	public void inicializarComponentes() {}

	@Override
	public void construirPainel() {
		PainelBuilder builder = new PainelBuilderImpl()
			.setTexto("DETALHES DA CORRIDA", Tema.FONTE_MUITO_FORTE)
			.setMuitoTexto(detalhamentoCorrida())
			.setBotao("VOLTAR", this::voltarBotao);

		if (loginDTO.tipoUsuario().equals(TipoUsuario.MOTOTAXISTA)) {
			builder.setBotao("REINVINDICAR", this::reinvidicarBotao);
		}

		detalhadorDeCorrida = builder.construir();
	}

	@Override
	public Painel factoryMethod() {
		return detalhadorDeCorrida;
	}
}
