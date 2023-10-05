package com.atosalves.view.paineis;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.abstractfactory.*;

public class LoginPainel extends PainelPadrao {

	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo combo;

	private UsuarioController usuarioController;

	public LoginPainel() {
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuario.values());
		construirComponentes();
		// usuarioController = new UsuarioController(this);
	}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("email", email)
			.senhaCaixa("senha", senha)
			.comboBox(combo)
			.botao(
				"ENTRAR",
				() ->
					usuarioController.loginBotao(
						new LoginDTO(
							email.getText(),
							new String(senha.getPassword())
						)
					)
			)
			// .botao("CADASTRAR", () -> usuarioController.cadastroBotao())
			.construir();
	}
}
