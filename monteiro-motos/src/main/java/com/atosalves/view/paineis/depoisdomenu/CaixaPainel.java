package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.builder.PainelBuilderImpl;
import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
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
	protected void inicializarComponentes(ComponentesFactory fabrica) {
		voltar = fabrica.criarBotao("VOLTAR");
	}

	@Override
	protected PainelPadrao montarComponentes(PainelBuilderImpl construtor) {
		return construtor.setTexto("*VALOR*", Tema.FONTE_MUITO_FORTE).setBotao(voltar).construir();
	}
}
