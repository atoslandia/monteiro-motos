package com.atosalves.view.paineis.factorymethod.depoisdomenu;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.view.janelas.JanelaDeAviso;
import com.atosalves.view.paineis.factorymethod.PainelTemplate;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilder;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class ExtratoPainel extends PainelTemplate {

	private LoginDTO loginDTO;
	private String saldo;

	public ExtratoPainel(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
		this.saldo = Float.toString(new UsuarioController().consultarSaldo(loginDTO)) + " R$";
	}

	private void voltarBotao() {
		painel.setPainel(new MenuPainel(loginDTO).criarPainel());
	}

	private void enviarHistorico() {
		UsuarioController usuarioController = new UsuarioController();
		usuarioController.enviarExtrato(loginDTO);
		new JanelaDeAviso("Enviado com sucesso!");
	}

	@Override
	public void construirPainel() {
		PainelBuilder builder = new PainelBuilderImpl().setTexto("EXTRATO", Tema.FONTE_MUITO_FORTE).setTexto(saldo, Tema.FONTE_FORTE);
		if (loginDTO.tipoUsuario() == TipoUsuario.PASSAGEIRO) {
			builder.setBotao("ENVIAR HISTÓRICO", this::enviarHistorico);
		}
		painel = builder.setBotao("VOLTAR", this::voltarBotao).construir();
	}

	@Override
	public void inicializarComponentes() {}
}
