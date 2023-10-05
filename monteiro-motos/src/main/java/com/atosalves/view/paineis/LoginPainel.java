package com.atosalves.view.paineis;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.abstractfactory.*;

public class LoginPainel extends PainelPadrao<UsuarioController> {

	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo combo;

	public LoginPainel() {
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuario.values());
		construirComponentes();
	}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("email", email)
			.senhaCaixa("senha", senha)
			.comboBox(combo)
			.botao(
				"ENTRAR",
				() -> {
					LoginDTO data = new LoginDTO(
						email.getText(),
						new String(senha.getPassword())
					);
					controller.loginBotao(data);
				}
			)
			.botao("CADASTRAR", () -> controller.cadastroBotao())
			.construir();
	}
}
