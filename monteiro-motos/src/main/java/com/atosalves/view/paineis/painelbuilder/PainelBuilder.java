package com.atosalves.view.paineis.painelbuilder;

import com.atosalves.view.componentes.DataCaixa;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.paineis.Painel;
import java.awt.Font;
import java.awt.Image;

public interface PainelBuilder {
	PainelBuilder setTexto(String titulo, Font fonte);
	PainelBuilder setTextoCaixa(String titulo, TextoCaixa textoCaixa);
	PainelBuilder setSenhaCaixa(SenhaCaixa senhaCaixa);
	PainelBuilder setBotao(String titulo);
	PainelBuilder setBotaoMenu(String titulo);
	PainelBuilder setDataCaixa(DataCaixa dataCaixa);
	PainelBuilder setTipoUsuarioCombo(TipoUsuarioCombo tipoUsuarioCombo);
	PainelBuilder setImagem(Image imagem);
	Painel construir();
}
