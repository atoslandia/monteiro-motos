package com.atosalves.view.paineis.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.menu.InicioMenuPainel;
import com.atosalves.view.util.Tema;

public class LoginPainel extends PainelPadrao {

	private CaixaTexto email;
	private CaixaSenha senha;

	private TipoUsuarioCombo tipoUsuarioCombo;

	private Botao entrar;
	private Botao cadastrar;

	public LoginPainel() {
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
				// TODO: janela de erro
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
	protected void construirComponentes() {
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.tipoUsuarioCombo = fabrica.criarComboTipoUsuario();
		this.entrar = fabrica.criarBotao();
		this.cadastrar = fabrica.criarBotao();

		construtor
			.texto("MONTEIRO MOTOS", Tema.FONTE_MUITO_FORTE)
			.caixaTexto("EMAIL:", email)
			.senhaCaixa("SENHA:", senha)
			.comboBox(tipoUsuarioCombo)
			.botao("ENTRAR", entrar)
			.botao("CADASTRAR", cadastrar)
			.construir();
	}
}
