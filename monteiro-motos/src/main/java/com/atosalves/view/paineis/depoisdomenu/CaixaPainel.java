package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.menu.InicioMenuPainel;
import com.atosalves.view.util.Tema;

public class CaixaPainel extends PainelPadrao {

	private Botao voltar;

	public CaixaPainel() {
		voltar();
	}

	private void voltar() {
		voltar.aoClicar(() -> setPainel(new InicioMenuPainel()));
	}

	@Override
	protected void construirComponentes() {
		voltar = fabrica.criarBotao();
		// TODO: trocar *VALOR* por uma função do controller
		construtor.texto("*VALOR*", Tema.FONTE_MUITO_FORTE).botao("VOLTAR", voltar).construir();
	}
}
