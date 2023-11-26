package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.menu.InicioMenuPainel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class ListaPainel extends Painel {

	private Botao voltar;

	public ListaPainel() {
		voltar();
	}

	private void voltar() {
		voltar.aoClicar(() -> setPainel(new InicioMenuPainel()));
	}

	@Override
	protected void inicializarComponentes(ComponentesFactory fabrica) {
		this.voltar = fabrica.criarBotao("VOLTAR");
	}

	@Override
	protected Painel montarComponentes(PainelBuilderImpl construtor) {
		return construtor.setTexto("USUÁRIOS OU CORRIDAS", Tema.FONTE_MUITO_FORTE).setBotao(voltar).construir();
	}
}
