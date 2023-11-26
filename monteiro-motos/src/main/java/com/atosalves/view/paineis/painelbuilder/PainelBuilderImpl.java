package com.atosalves.view.paineis.painelbuilder;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.DataCaixa;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.Texto;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.util.Tema;
import java.awt.Font;
import java.awt.Image;

public class PainelBuilderImpl implements PainelBuilder {

	private Painel painel;
	private ComponentesFactory fabrica;
	private PosicionadorDeComponentes posicionador;

	public PainelBuilderImpl() {
		this.painel = new Painel();

		this.fabrica = new ComponentesFactory();
		this.posicionador = new PosicionadorDeComponentes();
	}

	@Override
	public PainelBuilder setTexto(String titulo, Font fonte) {
		Texto texto = fabrica.criarTexto(titulo, fonte);
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

	public PainelBuilder setBotao(String titulo) {
		Botao botao = fabrica.criarBotao(titulo);
		posicionador.posicionarComponente(botao);

		painel.getBotoes().put(titulo, botao);

		painel.add(botao);
		return this;
	}

	public PainelBuilder setBotaoMenu(String titulo) {
		Botao botao = fabrica.criarBotaoMenu(titulo);
		posicionador.posicionarComponente(botao);

		painel.getBotoes().put(titulo, botao);

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
}
