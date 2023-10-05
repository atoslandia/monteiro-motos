package com.atosalves.view.paineis;

import com.atosalves.view.abstractfactory.SenhaCaixa;
import com.atosalves.view.abstractfactory.TextoCaixa;
import com.atosalves.view.abstractfactory.TipoUsuarioCombo;
import com.atosalves.view.abstractfactory.TiposUsuario;

public class CadastroPainel extends PainelPadrao {

	private TextoCaixa nome;
	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo combo;

	public CadastroPainel() {
		this.nome = fabrica.criarCaixaTexto();
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuario.values());
		construirComponentes();
	}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("NOME", nome)
			.caixaTexto("EMAIL", email)
			.senhaCaixa("SENHA", senha)
			.comboBox(combo)
			.botao("CADASTRAR", null)
			.construir();
	}
}
