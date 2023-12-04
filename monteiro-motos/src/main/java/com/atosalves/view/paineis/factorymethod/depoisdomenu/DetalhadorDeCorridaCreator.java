package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilder;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DetalhadorDeCorridaCreator implements PainelCreator {

	private Painel detalhadorDeCorrida;

	private CorridaDTO corridaDTO;
	private LoginDTO loginDTO;

	public DetalhadorDeCorridaCreator(CorridaDTO corridaDTO, LoginDTO loginDTO) {
		this.corridaDTO = corridaDTO;
		this.loginDTO = loginDTO;
	}

	private void voltar() {
		detalhadorDeCorrida.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	private String detalhamentoCorrida() {
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
			.setBotao("VOLTAR", this::voltar);

		if (loginDTO.tipoUsuario().equals(TipoUsuario.MOTOTAXISTA)) {
			builder.setBotao("REINVINDICAR", null);
		}

		detalhadorDeCorrida = builder.construir();
	}

	@Override
	public Painel factoryMethod() {
		return detalhadorDeCorrida;
	}
}
