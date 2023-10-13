package com.atosalves.view.paineis;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.paineis.menu.MenuPainel;
import com.atosalves.view.util.Tema;

public class CaixaPainel extends PainelPadrao {

	private Botao voltar;

	public CaixaPainel() {
		voltar();
	}

	private void voltar() {
		voltar.aoClicar(() -> setPainel(new MenuPainel()));
	}

	@Override
	protected void construirComponentes() {
		// TODO trocar *VALOR* por uma função do controller
		construtor
			.texto("*VALOR*", Tema.TEXTO_FONTE_MUITO_FORTE)
			.botao("VOLTAR", voltar)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		voltar = fabrica.criarBotao();
	}
}
