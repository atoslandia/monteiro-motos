package com.atosalves.view.builder;

import com.atosalves.view.PainelPadrao;
import com.atosalves.view.abstractfactory.Botao;
import com.atosalves.view.abstractfactory.ComponentesFactory;
import com.atosalves.view.abstractfactory.SenhaCaixa;
import com.atosalves.view.abstractfactory.TextoCaixa;
import com.atosalves.view.abstractfactory.TipoUsuarioCombo;
import java.awt.event.ActionListener;

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

	public ConstrutorPainel botao(String titulo, ActionListener acao) {
		Botao botao = fabrica.criarBotao(titulo);
		botao.addActionListener(acao);
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
