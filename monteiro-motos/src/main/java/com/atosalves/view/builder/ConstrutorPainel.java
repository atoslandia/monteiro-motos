package com.atosalves.view.builder;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;

public class ConstrutorPainel {

	// padrão de projeto builder fluent
	private PainelPadrao tela;
	private ComponentesFactory fabrica;

	public ConstrutorPainel(PainelPadrao tela) {
		this.tela = tela;
		this.fabrica = new ComponentesFactory();
	}

	public ConstrutorPainel texto(String titulo) {
		tela.add(fabrica.criarTexto(titulo));

		return this;
	}

	public ConstrutorPainel botao(String titulo, Botao botao) {
		botao.setText(titulo);
		tela.add(botao);
		return this;
	}

	public ConstrutorPainel caixaTexto(String titulo, TextoCaixa caixa) {
		tela.add(fabrica.criarTexto(titulo));
		tela.add(caixa);

		return this;
	}

	public ConstrutorPainel senhaCaixa(String titulo, SenhaCaixa senha) {
		tela.add(fabrica.criarTexto(titulo));
		tela.add(senha);

		return this;
	}

	public ConstrutorPainel comboBox(TipoUsuarioCombo combo) {
		tela.add(combo);

		return this;
	}

	public PainelPadrao construir() {
		return tela;
	}
}
