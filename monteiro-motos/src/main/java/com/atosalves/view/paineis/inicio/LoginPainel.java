package com.atosalves.view.paineis.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.builder.PainelBuilderImpl;
import com.atosalves.view.componentes.*;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.menu.InicioMenuPainel;
import com.atosalves.view.util.Tema;

public class LoginPainel extends PainelPadrao {

	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo tipoUsuarioCombo;

	private Botao entrar;
	private Botao cadastrar;

	public LoginPainel() {
		super();
		setFundo(Tema.FUNDO_LOGIN);
		botaoEntrar();
		botaoCadastrar();
	}

	private LoginDTO data() {
		System.out.println(email.pegarCampo());
		System.out.println(senha.pegarCampo());
		System.out.println(tipoUsuarioCombo.pegarSelecionado());

		return new LoginDTO(email.pegarCampo(), senha.pegarCampo(), tipoUsuarioCombo.pegarSelecionado());
	}

	private void botaoEntrar() {
		entrar.aoClicar(() -> {
			var controller = new UsuarioController();

			if (controller.login(data())) {
				setPainel(new InicioMenuPainel());
			} else {
				new JanelaDeErro("Usuário não encontrado");
			}
		});
	}

	private void botaoCadastrar() {
		cadastrar.aoClicar(() -> {
			var cadastro = new CadastroEditarUsuarioPainel();
			setPainel(cadastro);
		});
	}

	@Override
	protected void inicializarComponentes(ComponentesFactory factory) {
		this.email = factory.criarCaixaTexto();
		this.senha = factory.criarCaixaSenha();
		this.tipoUsuarioCombo = factory.criarComboTipoUsuario();
		this.entrar = factory.criarBotao("ENTRAR");
		this.cadastrar = factory.criarBotao("CADASTRAR");
	}

	@Override
	protected PainelPadrao montarComponentes(PainelBuilderImpl builder) {
		return builder
			.setTexto("MONTEIRO MOTOS", Tema.FONTE_MUITO_FORTE)
			.setTextoCaixa("EMAIL", email)
			.setSenhaCaixa(senha)
			.setTipoUsuarioCombo(tipoUsuarioCombo)
			.setBotao(entrar)
			.setBotao(cadastrar)
			.construir();
	}
}
