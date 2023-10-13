package com.atosalves.view.paineis;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.paineis.menu.MenuPainel;
import com.atosalves.view.util.Tema;

public class ListaPainel extends PainelPadrao {

	private Botao voltar;

	public ListaPainel() {
		voltar();
	}

	private void voltar() {
		voltar.aoClicar(() -> setPainel(new MenuPainel()));
	}

	@Override
	protected void construirComponentes() {
		construtor
			.texto("USUÁRIOS OU CORRIDAS", Tema.TEXTO_FONTE_MUITO_FORTE)
			.botao("VOLTAR", voltar)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.voltar = fabrica.criarBotao();
	}
}
