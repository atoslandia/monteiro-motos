package com.atosalves.view.paineis.factorymethod.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.controller.exceptions.CredenciaisInvalidasException;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.*;
import com.atosalves.view.exception.CampoInvalidoException;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.factorymethod.PainelTemplate;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class LoginPainel extends PainelTemplate {

	private EmailCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo tipoUsuarioCombo;

	private LoginDTO getDados() throws CampoInvalidoException {
		return new LoginDTO(email.pegarCampo(), senha.pegarCampo(), tipoUsuarioCombo.pegarSelecionado());
	}

	private void loginBotao() {
		try {
			LoginDTO dados = getDados();
			var usuarioController = new UsuarioController();
			usuarioController.login(dados);
			painel.setPainel(new MenuPainel(dados).criarPainel());
		} catch (CredenciaisInvalidasException CredenciaisInvalidas) {
			new JanelaDeErro(CredenciaisInvalidas);
		} catch (Exception exception) {
			new JanelaDeErro(exception);
		}
	}

	private void cadastroBotao() {
		painel.setPainel(new CadastroUsuarioPainel().criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		this.email = COMPONENTES_FACTORY.criarEmailCaixa();
		this.senha = COMPONENTES_FACTORY.criarCaixaSenha();
		this.tipoUsuarioCombo = COMPONENTES_FACTORY.criarComboTipoUsuario();
	}

	@Override
	public void construirPainel() {
		painel =
			new PainelBuilderImpl()
				.setImagem(Tema.FUNDO_LOGIN)
				.setTexto("MONTEIRO MOTOS", Tema.FONTE_MUITO_FORTE)
				.setTextoCaixa("EMAIL", email)
				.setSenhaCaixa(senha)
				.setTipoUsuarioCombo(tipoUsuarioCombo)
				.setBotao("LOGIN", this::loginBotao)
				.setBotao("CADASTRO", this::cadastroBotao)
				.construir();
	}
}
