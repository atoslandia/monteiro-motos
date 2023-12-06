package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.NumeroCaixa;
import com.atosalves.view.janelas.JanelaDeAviso;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class DepositarSaldoCreator implements PainelCreator {

	private NumeroCaixa valor;

	private Painel depositarSaldoPainel;

	private LoginDTO loginDTO;

	public DepositarSaldoCreator(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	private void depositarBotao() {
		try {
			String campo = valor.pegarCampo();

			float valor = Float.parseFloat(campo);

			UsuarioController usuarioController = new UsuarioController();
			usuarioController.depositarNaConta(loginDTO, valor);

			new JanelaDeAviso("Depositado com sucesso!");
			depositarSaldoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
		} catch (Exception exception) {
			new JanelaDeErro(exception);
		}
	}

	private void voltarBotao() {
		depositarSaldoPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		this.valor = COMPONENTES_FACTORY.criarNumeroCaixa();
	}

	@Override
	public void construirPainel() {
		depositarSaldoPainel =
			new PainelBuilderImpl()
				.setTexto("DEPOSITAR SALDO", Tema.FONTE_MUITO_FORTE)
				.setTextoCaixa("VALOR", valor)
				.setBotao("DEPOSITAR", this::depositarBotao)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return depositarSaldoPainel;
	}
}
