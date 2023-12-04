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
	public PainelBuilder setMuitoTexto(String titulo) {
		Texto texto = factory.criarTexto(titulo, Tema.FONTE_NORMAL);
		posicionador.posicionarComponenteGrande(texto);

		painel.add(texto);
		return this;
	}

	@Override
	public PainelBuilder setTextoCaixa(String titulo, TextoCaixa textoCaixa) {
		setTexto(titulo, Tema.FONTE_NORMAL);
		posicionador.posicionarComponenteNormal(textoCaixa);
		painel.add(textoCaixa);
		return this;
	}

	@Override
	public PainelBuilder setSenhaCaixa(SenhaCaixa senhaCaixa) {
		setTexto("SENHA", Tema.FONTE_NORMAL);
		posicionador.posicionarComponenteNormal(senhaCaixa);
		painel.add(senhaCaixa);
		return this;
	}

	@Override
	public PainelBuilder setBotao(String titulo, Runnable runnable) {
		Botao botao = factory.criarBotao(titulo);
		posicionador.posicionarComponenteNormal(botao);

		botao.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					runnable.run();
				}
			}
		);

		painel.setBotao(titulo, botao);

		painel.add(botao);
		return this;
	}

	@Override
	public PainelBuilder setBotaoMenu(String titulo, Runnable runnable, boolean isAtivo) {
		Botao botao = factory.criarBotaoMenu(titulo);
		if (titulo.equals("INICIO")) {
			botao.setBounds(0, 300, 200, 80);
		} else if (titulo.equals("CORRIDAS")) {
			botao.setBounds(199, 300, 345, 80);
		} else {
			botao.setBounds(543, 300, 210, 80);
		}

		botao.setEnabled(isAtivo);

		botao.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					runnable.run();
				}
			}
		);

		painel.setBotao(titulo, botao);

		painel.add(botao);
		return this;
	}

	@Override
	public PainelBuilder setDataCaixa(DataCaixa dataCaixa) {
		posicionador.posicionarComponenteNormal(dataCaixa);
		painel.add(dataCaixa);
		return this;
	}

	@Override
	public PainelBuilder setTipoUsuarioCombo(TipoUsuarioCombo tipoUsuarioCombo) {
		posicionador.posicionarComponenteNormal(tipoUsuarioCombo);
		painel.add(tipoUsuarioCombo);
		return this;
	}

	@Override
	public PainelBuilder setImagem(Image imagem) {
		painel.setFundo(imagem);
		return this;
	}

	@Override
	public PainelBuilder setListaDeItems(ListaDeCorridas listaDeItems, Runnable runnable) {
		listaDeItems.aoClicar(runnable);
		posicionador.posicionarComponenteGrande(listaDeItems);
		painel.add(listaDeItems);
		return this;
	}

	@Override
	public PainelBuilder addPainel(Painel painelMenor) {
		painelMenor.setBounds(0, 0, 768, 412);
		painel.add(painelMenor);
		return this;
	}

	@Override
	public Painel construir() {
		return painel;
	}

	private class PosicionadorDeComponentes {

		private int posicaoHorizontal = 10;
		private int posicaoVertical = 5;

		public void posicionarComponenteNormal(JComponent componente) {
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

		public void posicionarComponenteGrande(JComponent componente) {
			int largura = 730;
			int altura = 200;
			componente.setBounds(posicaoHorizontal, posicaoVertical, largura, altura);
			posicaoVertical += altura + 5;
		}
	}
}
