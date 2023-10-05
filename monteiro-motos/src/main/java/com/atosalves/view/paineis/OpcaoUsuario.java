package com.atosalves.view.paineis;

public class OpcaoUsuario extends PainelPadrao {

	public OpcaoUsuario() {
		construirComponentes();
	}

	@Override
	protected void construirComponentes() {
		construtor
			.botao("ADMINISTRADOR", null)
			.botao("PASSAGEIRO", null)
			.botao("MOTOTAXISTA", null)
			.construir();
	}
}
