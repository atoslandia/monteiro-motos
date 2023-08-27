package com.atosalves.view.paineis;

import com.atosalves.view.PainelPadrao;

public class InicioPainel extends PainelPadrao {

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
