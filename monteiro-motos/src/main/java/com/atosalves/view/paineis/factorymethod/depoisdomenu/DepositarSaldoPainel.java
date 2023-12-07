package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.view.componentes.NumeroCaixa;
import com.atosalves.view.janelas.JanelaDeAviso;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.factorymethod.PainelTemplate;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DepositarSaldoPainel extends PainelTemplate {

	private NumeroCaixa valor;
	private LoginDTO loginDTO;

	public DepositarSaldoPainel(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void depositarBotao() {
		try {
			String campo = valor.pegarCampo();

			float valor = Float.parseFloat(campo);

			UsuarioController usuarioController = new UsuarioController();
			usuarioController.depositarNaConta(loginDTO, valor);

			new JanelaDeAviso("Depositado com sucesso!");
			painel.setPainel(new MenuPainel(loginDTO).criarPainel());
		} catch (Exception exception) {
			new JanelaDeErro(exception);
		}
	}

	private void voltarBotao() {
		painel.setPainel(new MenuPainel(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		this.valor = COMPONENTES_FACTORY.criarNumeroCaixa();
	}

	@Override
	public void construirPainel() {
		painel =
			new PainelBuilderImpl()
				.setTexto("DEPOSITAR SALDO", Tema.FONTE_MUITO_FORTE)
				.setTextoCaixa("VALOR", valor)
				.setBotao("DEPOSITAR", this::depositarBotao)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}
}
