package com.atosalves.view.paineis;

public class OpcaoUsuario extends PainelPadrao {

	public OpcaoUsuario() {
		construirComponentes();
	}

	@Override
	public void construirComponentes() {
		construtor
			.botao(
				"ADMINISTRADOR",
				() -> {
					this.setVisible(false);
					add(new LoginPainel());
				}
			)
			.botao("PASSAGEIRO", null)
			.botao("MOTOTAXISTA", null)
			.construir();
	}
}
