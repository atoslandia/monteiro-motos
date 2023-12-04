package com.atosalves.view.paineis.painelbuilder;

import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.Painel;
import java.awt.Font;
import java.awt.Image;

public interface PainelBuilder {
	PainelBuilder setTexto(String titulo, Font fonte);
	PainelBuilder setMuitoTexto(String titulo);
	PainelBuilder setTextoCaixa(String titulo, TextoCaixa textoCaixa);
	PainelBuilder setSenhaCaixa(SenhaCaixa senhaCaixa);
	PainelBuilder setBotao(String titulo, Runnable runnable);
	PainelBuilder setBotaoMenu(String titulo, Runnable runnable, boolean isAtivo);
	PainelBuilder setDataCaixa(DataCaixa dataCaixa);
	PainelBuilder setTipoUsuarioCombo(TipoUsuarioCombo tipoUsuarioCombo);
	PainelBuilder setImagem(Image imagem);
	PainelBuilder setListaDeItems(ListaDeCorridas listaDeItems, Runnable runnable);
	PainelBuilder addPainel(Painel painel);
	Painel construir();
}
