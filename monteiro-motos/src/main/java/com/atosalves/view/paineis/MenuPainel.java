package com.atosalves.view.paineis;

public class MenuPainel extends PainelPadrao {

	@Override
	protected void construirComponentes() {
		construtor
			.texto("INICIO")
			// .botao("VOLTAR")
			// .botao("LISTAR TODOS OS USUÁRIOS")
			// .botao("DEFINIR VALOR DE CRÉTIDO DE REINVIDICAÇÃO")
			// .botao("MANTER CAIXA")
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(
			"Unimplemented method 'instanciarComponentes'"
		);
	}
}
