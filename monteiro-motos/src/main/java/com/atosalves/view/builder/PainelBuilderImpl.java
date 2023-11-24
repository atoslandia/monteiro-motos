package com.atosalves.view.builder;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;
import java.awt.Font;
import javax.swing.JComponent;

public class PainelBuilderImpl implements PainelBuilder {

	private int posicaoHorizontal = 10;
	private int posicaoVertical = 5;

	// padrão de projeto builder fluent
	private PainelPadrao tela;
	private ComponentesFactory fabrica;

	public PainelBuilderImpl(PainelPadrao tela) {
		this.tela = tela;
		this.fabrica = new ComponentesFactory();
	}

	@Override
	public PainelBuilder setTexto(String titulo, Font fonte) {
		var texto = fabrica.criarTexto(titulo, fonte);
		setPosicao(texto, titulo);
		tela.add(texto);
		return this;
	}

	@Override
	public PainelBuilder setTextoCaixa(String titulo, TextoCaixa caixa) {
		var texto = fabrica.criarTexto(titulo, Tema.FONTE_NORMAL);

		setPosicao(texto, titulo);
		setPosicao(caixa);

		tela.add(texto);
		tela.add(caixa);

		return this;
	}

	@Override
	public PainelBuilder setSenhaCaixa(SenhaCaixa senha) {
		var titulo = "SENHA";
		var texto = fabrica.criarTexto(titulo, Tema.FONTE_NORMAL);

		setPosicao(texto, titulo);
		setPosicao(senha);

		tela.add(texto);
		tela.add(senha);

		return this;
	}

	@Override
	public PainelBuilder setBotao(Botao botao) {
		setPosicao(botao);
		tela.add(botao);

		return this;
	}

	@Override
	public PainelBuilder setTipoUsuarioCombo(TipoUsuarioCombo combo) {
		tela.add(combo);
		setPosicao(combo);
		return this;
	}

	private void setPosicao(JComponent componente) {
		int largura = 320;
		int altura = 30;
		componente.setBounds(posicaoHorizontal, posicaoVertical, largura, altura);
		posicaoVertical += altura + 5;
	}

	private void setPosicao(JComponent componente, String titulo) {
		int largura = componente.getFontMetrics(componente.getFont()).stringWidth(titulo) + 10;
		int altura = componente.getFontMetrics(componente.getFont()).getHeight();
		componente.setBounds(posicaoHorizontal, posicaoVertical, largura, altura);
		posicaoVertical += altura + 5;
	}

	@Override
	public PainelPadrao construir() {
		return tela;
	}
}
