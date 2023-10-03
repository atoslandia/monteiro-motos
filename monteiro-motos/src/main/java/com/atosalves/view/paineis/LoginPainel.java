package com.atosalves.view.paineis;

import com.atosalves.view.abstractfactory.*;

public class LoginPainel extends PainelPadrao {

	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo combo;

	public LoginPainel() {
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuarios.values());
		construirComponentes();
	}

	@Override
	public void construirComponentes() {
		construtor
			.caixaTexto("email", email)
			.senhaCaixa("senha", senha)
			.comboBox(combo)
			.botao(
				"ENTRAR",
				() -> {
					System.out.println(combo.getSelectedItem());
				}
			)
			.botao("CADASTRAR", null)
			.construir();
	}
}
