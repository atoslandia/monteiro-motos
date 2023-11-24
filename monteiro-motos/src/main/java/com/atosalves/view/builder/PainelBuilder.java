package com.atosalves.view.builder;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.paineis.PainelPadrao;
import java.awt.Font;

public interface PainelBuilder {
	PainelBuilder setTexto(String titulo, Font fonte);
	PainelBuilder setTextoCaixa(String titulo, TextoCaixa caixa);
	PainelBuilder setSenhaCaixa(SenhaCaixa senha);
	PainelBuilder setBotao(Botao botao);
	PainelBuilder setTipoUsuarioCombo(TipoUsuarioCombo combo);
	PainelPadrao construir();
}
