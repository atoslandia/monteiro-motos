package com.atosalves.view.builder;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.CaixaSenha;
import com.atosalves.view.componentes.CaixaTexto;
import com.atosalves.view.componentes.Texto;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;
import java.awt.Font;
import javax.swing.ButtonGroup;

public class ConstrutorPainel {

	private int contadorComponentes;

	private int espacoEntreComponentes = 45;

	private int posicaoHorizontal = 10;

	// padrão de projeto builder fluent
	private PainelPadrao tela;
	private ComponentesFactory fabrica;

	public ConstrutorPainel(PainelPadrao tela) {
		this.tela = tela;
		this.fabrica = new ComponentesFactory();
	}

	private int calcularPosicaoVertical() {
		int posicao = contadorComponentes++ * espacoEntreComponentes;
		return posicao;
	}

	public ConstrutorPainel texto(String titulo, Font fonte) {
		tela.add(textoFabrica(titulo, fonte));
		return this;
	}

	private Texto textoFabrica(String titulo, Font fonte) {
		var texto = fabrica.criarTexto(titulo);
		texto.setFont(fonte);

		texto.setBounds(
			posicaoHorizontal,
			calcularPosicaoVertical(),
			texto.getFontMetrics(texto.getFont()).stringWidth(titulo) + 10,
			50
		);
		return texto;
	}

	public ConstrutorPainel botao(String titulo, Botao botao) {
		botao.setText(titulo);
		botao.setBounds(
			posicaoHorizontal,
			calcularPosicaoVertical(),
			botao.getFontMetrics(botao.getFont()).stringWidth(titulo) + 40,
			35
		);

		tela.add(botao);

		return this;
	}

	public ConstrutorPainel caixaTexto(String titulo, CaixaTexto caixa) {
		var texto = textoFabrica(titulo, Tema.FONTE_FORTE);
		caixa.setBounds(posicaoHorizontal + texto.getText().length() * 15, texto.getY() + 8, 200, 35);

		tela.add(texto);
		tela.add(caixa);

		return this;
	}

	public ConstrutorPainel senhaCaixa(String titulo, CaixaSenha senha) {
		var texto = textoFabrica(titulo, Tema.FONTE_FORTE);

		senha.setBounds(posicaoHorizontal + texto.getText().length() * 15, texto.getY() + 8, 200, 35);

		tela.add(texto);
		tela.add(senha);

		return this;
	}

	public ConstrutorPainel comboBox(TipoUsuarioCombo combo) {
		tela.add(combo);
		combo.setBounds(posicaoHorizontal, calcularPosicaoVertical() + 7, 289, 30);
		return this;
	}

	public PainelPadrao construir() {
		return tela;
	}
}
