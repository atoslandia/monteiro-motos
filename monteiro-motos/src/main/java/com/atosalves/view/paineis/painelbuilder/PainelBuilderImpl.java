package com.atosalves.view.paineis.painelbuilder;

import com.atosalves.view.componentes.*;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.util.Tema;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

public class PainelBuilderImpl implements PainelBuilder {

	private Painel painel;

	private ComponentesFactoryImpl factory;
	private PosicionadorDeComponentes posicionador;

	public PainelBuilderImpl() {
		this.painel = new Painel();

		this.factory = new ComponentesFactoryImpl();
		this.posicionador = new PosicionadorDeComponentes();
	}

	@Override
	public PainelBuilder setTexto(String titulo, Font fonte) {
		Texto texto = factory.criarTexto(titulo, fonte);
		posicionador.posicionarComponenteComTitulo(texto, titulo);
		painel.add(texto);
		return this;
	}

	@Override
	public PainelBuilder setTextoCaixa(String titulo, TextoCaixa textoCaixa) {
		setTexto(titulo, Tema.FONTE_NORMAL);
		posicionador.posicionarComponente(textoCaixa);
		painel.add(textoCaixa);
		return this;
	}

	@Override
	public PainelBuilder setSenhaCaixa(SenhaCaixa senhaCaixa) {
		setTexto("SENHA", Tema.FONTE_NORMAL);
		posicionador.posicionarComponente(senhaCaixa);
		painel.add(senhaCaixa);
		return this;
	}

	@Override
	public PainelBuilder setBotao(String titulo, Runnable... runnables) {
		Botao botao = factory.criarBotao(titulo);
		posicionador.posicionarComponente(botao);

		for (Runnable runnable : runnables) {
			botao.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						runnable.run();
					}
				}
			);
		}

		painel.setBotao(titulo, botao);

		painel.add(botao);
		return this;
	}

	@Override
	public PainelBuilder setBotaoMenu(String titulo, Runnable... runnables) {
		Botao botao = factory.criarBotaoMenu(titulo);
		posicionador.posicionarComponente(botao);

		for (Runnable runnable : runnables) {
			botao.addActionListener(
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						runnable.run();
					}
				}
			);
		}

		painel.setBotao(titulo, botao);

		painel.add(botao);
		return this;
	}

	@Override
	public PainelBuilder setDataCaixa(DataCaixa dataCaixa) {
		posicionador.posicionarComponente(dataCaixa);
		painel.add(dataCaixa);
		return this;
	}

	@Override
	public PainelBuilder setTipoUsuarioCombo(TipoUsuarioCombo tipoUsuarioCombo) {
		posicionador.posicionarComponente(tipoUsuarioCombo);
		painel.add(tipoUsuarioCombo);
		return this;
	}

	@Override
	public PainelBuilder setImagem(Image imagem) {
		painel.setFundo(imagem);
		return this;
	}

	@Override
	public Painel construir() {
		return painel;
	}

	private class PosicionadorDeComponentes {

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
}
