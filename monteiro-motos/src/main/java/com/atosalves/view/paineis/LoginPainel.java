package com.atosalves.view.paineis;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;

public class LoginPainel extends PainelPadrao {

	private CaixaTexto email;
	private CaixaSenha senha;
	private TipoUsuarioCombo combo;

	private Botao entrar;
	private Botao cadastrar;

	public LoginPainel() {
		entrar();
		cadastrar();
	}

	private void entrar() {
		entrar.aoClicar(() -> {
			var controller = new UsuarioController();

			if (controller.login(data())) {
				setPainel(new MenuPainel());
			} else {
				// TODO janela de erro
			}
		});
	}

	private void cadastrar() {
		cadastrar.aoClicar(() -> {
			var cadastro = new CadastroEditarUsuarioPainel();
			setPainel(cadastro);
		});
	}

	private LoginDTO data() {
		return new LoginDTO(email.pegarCampo(), senha.pegarCampo());
	}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("email", email)
			.senhaCaixa("senha", senha)
			.comboBox(combo)
			.botao("ENTRAR", entrar)
			.botao("CADASTRAR", cadastrar)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuario.values());
		this.entrar = fabrica.criarBotao();
		this.cadastrar = fabrica.criarBotao();
	}
}
