package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.BotaoComponente;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.menu.InicioMenuPainel;
import com.atosalves.view.util.Tema;

public class ListaPainel extends PainelPadrao {

	private BotaoComponente voltar;

	public ListaPainel() {
		voltar();
	}

	private void voltar() {
		voltar.aoClicar(() -> setPainel(new InicioMenuPainel()));
	}

	@Override
	protected void construirComponentes() {
		this.voltar = fabrica.criarBotao();

		construtor
			.texto("USUÁRIOS OU CORRIDAS", Tema.FONTE_MUITO_FORTE)
			.botao("VOLTAR", voltar)
			.construir();
	}
}
