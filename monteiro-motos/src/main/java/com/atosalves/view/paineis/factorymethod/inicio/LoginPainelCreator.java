package com.atosalves.view.paineis.factorymethod.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dao.exceptions.UsuarioNaoEncontradoException;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class LoginPainelCreator implements PainelCreator {

	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo tipoUsuarioCombo;

	private Painel loginPainel;

	private LoginDTO getDados() {
		return new LoginDTO(
			email.pegarCampo(),
			senha.pegarCampo(),
			tipoUsuarioCombo.pegarSelecionado()
		);
	}

	private void loginBotao() {
		var usuarioController = new UsuarioController();

		try {
			if (usuarioController.login(getDados())) {
				loginPainel.setLoginDTO(getDados());
				loginPainel.setPainel(new MenuPainelCreator().criarPainel());
			} else {
				// TODO: apagar depois
				System.out.println("deu errado");
			}
		} catch (UsuarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cadastroBotao() {
		loginPainel.setPainel(new CadastroUsuarioPainelCreator().criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		this.email = COMPONENTES_FACTORY.criarCaixaTexto();
		this.senha = COMPONENTES_FACTORY.criarCaixaSenha();
		this.tipoUsuarioCombo = COMPONENTES_FACTORY.criarComboTipoUsuario();
	}

	@Override
	public void construirPainel() {
		loginPainel =
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

	@Override
	public Painel factoryMethod() {
		return loginPainel;
	}
}
