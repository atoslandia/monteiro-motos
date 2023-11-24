package com.atosalves.view.builder;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;
import java.awt.Font;

public class PainelBuilderImpl implements PainelBuilder {

	// padrão de projeto builder fluent
	private PainelPadrao tela;
	private ComponentesFactory fabrica;
	private PosicionadorDeComponentes posicionador;

	public PainelBuilderImpl(PainelPadrao tela) {
		this.tela = tela;
		this.fabrica = new ComponentesFactory();
		this.posicionador = new PosicionadorDeComponentes();
	}

	@Override
	public PainelBuilder setTexto(String titulo, Font fonte) {
		var texto = fabrica.criarTexto(titulo, fonte);
		posicionador.posicionarComponenteComTitulo(texto, titulo);
		tela.add(texto);
		return this;
	}

	@Override
	public PainelBuilder setTextoCaixa(String titulo, TextoCaixa caixa) {
		var texto = fabrica.criarTexto(titulo, Tema.FONTE_NORMAL);

		posicionador.posicionarComponenteComTitulo(texto, titulo);
		posicionador.posicionarComponente(caixa);

		tela.add(texto);
		tela.add(caixa);

		return this;
	}

	@Override
	public PainelBuilder setSenhaCaixa(SenhaCaixa senha) {
		var titulo = "SENHA";
		var texto = fabrica.criarTexto(titulo, Tema.FONTE_NORMAL);

		posicionador.posicionarComponenteComTitulo(texto, titulo);
		posicionador.posicionarComponente(senha);

		tela.add(texto);
		tela.add(senha);

		return this;
	}

	@Override
	public PainelBuilder setBotao(Botao botao) {
		posicionador.posicionarComponente(botao);
		tela.add(botao);

		return this;
	}

	@Override
	public PainelBuilder setTipoUsuarioCombo(TipoUsuarioCombo combo) {
		tela.add(combo);
		posicionador.posicionarComponente(combo);
		return this;
	}

	@Override
	public PainelPadrao construir() {
		return tela;
	}
}
