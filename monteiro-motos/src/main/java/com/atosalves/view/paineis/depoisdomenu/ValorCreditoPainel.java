package com.atosalves.view.paineis.depoisdomenu;

import com.atosalves.view.builder.PainelBuilderImpl;
import com.atosalves.view.componentes.*;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.menu.InicioMenuPainel;

public class ValorCreditoPainel extends PainelPadrao {

	private TextoCaixa valor;
	private Botao definir;
	private Botao voltar;

	public ValorCreditoPainel() {
		voltar();
	}

	private void voltar() {
		voltar.aoClicar(() -> setPainel(new InicioMenuPainel()));
	}

	@Override
	protected void inicializarComponentes(ComponentesFactory fabrica) {
		this.valor = fabrica.criarCaixaTexto();
		this.definir = fabrica.criarBotao("DEFINIR");
		this.voltar = fabrica.criarBotao("VOLTAR");
	}

	@Override
	protected PainelPadrao montarComponentes(PainelBuilderImpl construtor) {
		return construtor.setTextoCaixa("VALOR", valor).setBotao(definir).setBotao(voltar).construir();
	}
}
