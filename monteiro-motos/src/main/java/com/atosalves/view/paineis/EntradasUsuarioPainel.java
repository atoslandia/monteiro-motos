package com.atosalves.view.paineis;

import com.atosalves.view.componentes.CaixaSenha;
import com.atosalves.view.componentes.CaixaTexto;

public class EntradasUsuarioPainel extends PainelPadrao {

	private CaixaTexto nome;

	private CaixaTexto email;
	private CaixaSenha senha;

	public EntradasUsuarioPainel() {}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("NOME: ", nome)
			.caixaTexto("EMAIL:", email)
			.senhaCaixa("SENHA:", senha)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.nome = fabrica.criarCaixaTexto();
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
	}
}
