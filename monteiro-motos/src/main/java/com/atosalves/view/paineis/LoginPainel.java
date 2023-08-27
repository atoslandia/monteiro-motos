package com.atosalves.view.paineis;

import com.atosalves.view.PainelPadrao;
import com.atosalves.view.abstractfactory.*;

public class LoginPainel extends PainelPadrao {

	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo combo;

	public LoginPainel() {
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuarios.values());
		setVisible(true);
	}

	@Override
	public void construirComponentes() {
		construtor
			.caixaTexto("email", email)
			.senhaCaixa("senha", senha)
			.comboBox(combo)
			.botao("ENTRAR", null)
			.construir();
	}
}
