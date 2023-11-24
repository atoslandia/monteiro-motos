package com.atosalves.view.builder;

import javax.swing.JComponent;

public class PosicionadorDeComponentes {

	private int posicaoHorizontal = 10;
	private int posicaoVertical = 5;

	public void posicionarComponente(JComponent componente) {
		int largura = 320;
		int altura = 30;
		componente.setBounds(posicaoHorizontal, posicaoVertical, largura, altura);
		posicaoVertical += altura + 5;
	}

	public void posicionarComponenteComTitulo(JComponent componente, String titulo) {
		int largura = componente.getFontMetrics(componente.getFont()).stringWidth(titulo) + 10;
		int altura = componente.getFontMetrics(componente.getFont()).getHeight();
		componente.setBounds(posicaoHorizontal, posicaoVertical, largura, altura);
		posicaoVertical += altura + 5;
	}
}
