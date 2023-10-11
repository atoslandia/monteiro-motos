package com.atosalves.view.builder;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.CaixaSenha;
import com.atosalves.view.componentes.CaixaTexto;
import com.atosalves.view.componentes.Texto;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;

public class ConstrutorPainel {

	private int contadorComponentes;
	private int numComponentes;

	private int espacoEntreComponentes = 38;

	// padrão de projeto builder fluent
	private PainelPadrao tela;
	private ComponentesFactory fabrica;

	public ConstrutorPainel(PainelPadrao tela) {
		this.tela = tela;
		this.fabrica = new ComponentesFactory();
	}

	public ConstrutorPainel definirNumComponentes(int numComponentes) {
		this.numComponentes = numComponentes;
		return this;
	}

	private int calcularPosicaoVertical() {
		int posicao = 0;
		if (contadorComponentes <= numComponentes + 1) {
			posicao = contadorComponentes++ * espacoEntreComponentes;
		}
		return posicao;
	}

	public ConstrutorPainel texto(String titulo, boolean fonteGrande) {
		tela.add(textoFabrica(titulo, fonteGrande));
		return this;
	}

	private Texto textoFabrica(String titulo, boolean fonteGrande) {
		var texto = fabrica.criarTexto(titulo);
		if (fonteGrande) {
			texto.setFont(Tema.TEXTO_FONTE_MUITO_FORTE);
		}
		texto.setBounds(
			10,
			calcularPosicaoVertical(),
			texto.getFontMetrics(texto.getFont()).stringWidth(titulo) + 10,
			50
		);
		return texto;
	}

	public ConstrutorPainel botao(String titulo, Botao botao) {
		botao.setText(titulo);
		botao.setBounds(
			10,
			calcularPosicaoVertical(),
			botao.getFontMetrics(botao.getFont()).stringWidth(titulo) + 40,
			40
		);

		tela.add(botao);

		return this;
	}

	public ConstrutorPainel caixaTexto(String titulo, CaixaTexto caixa) {
		var texto = textoFabrica(titulo, false);
		caixa.setBounds(
			10 + texto.getText().length() * 15,
			texto.getY() + 8,
			200,
			35
		);

		tela.add(texto);
		tela.add(caixa);

		return this;
	}

	public ConstrutorPainel senhaCaixa(String titulo, CaixaSenha senha) {
		var texto = textoFabrica(titulo, false);

		senha.setBounds(
			10 + texto.getText().length() * 15,
			texto.getY() + 8,
			200,
			35
		);

		tela.add(texto);
		tela.add(senha);

		return this;
	}

	public ConstrutorPainel comboBox(TipoUsuarioCombo combo) {
		tela.add(combo);
		combo.setBounds(10, calcularPosicaoVertical(), 289, 35);
		return this;
	}

	public PainelPadrao construir() {
		return tela;
	}
}
