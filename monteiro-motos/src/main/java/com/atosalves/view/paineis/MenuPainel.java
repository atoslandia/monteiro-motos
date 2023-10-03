package com.atosalves.view.paineis;

public class MenuPainel extends PainelPadrao {

	@Override
	public void construirComponentes() {
		construtor
			.texto("INICIO")
			.botao("VOLTAR", null)
			.botao("LISTAR TODOS OS USUÁRIOS", null)
			.botao("DEFINIR VALOR DE CRÉTIDO DE REINVIDICAÇÃO", null)
			.botao("MANTER CAIXA", null)
			.construir();
	}
}
