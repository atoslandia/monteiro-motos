package com.atosalves.view.builder;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.DataCaixa;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.paineis.PainelPadrao;
import java.awt.Font;

public interface PainelBuilder {
	PainelBuilder setTexto(String titulo, Font fonte);
	PainelBuilder setTextoCaixa(String titulo, TextoCaixa textoCaixa);
	PainelBuilder setSenhaCaixa(SenhaCaixa senhaCaixa);
	PainelBuilder setBotao(Botao botao);
	PainelBuilder setDataCaixa(DataCaixa dataCaixa);
	PainelBuilder setTipoUsuarioCombo(TipoUsuarioCombo comboBox);
	PainelPadrao construir();
}
