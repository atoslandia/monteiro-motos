package com.atosalves.view.componentes.componentesafactory;

import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.DataCaixa;
import com.atosalves.view.componentes.ListaDeItems;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.Texto;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import java.awt.Font;

public interface ComponentesFactory {
	SenhaCaixa criarCaixaSenha();
	TextoCaixa criarCaixaTexto();
	Texto criarTexto(String texto, Font fonte);
	DataCaixa criarDataCaixa();
	TipoUsuarioCombo criarComboTipoUsuario();
	Botao criarBotao(String titulo);
	// TODO: apagar esse método depois
	Botao criarBotaoMenu(String titulo);
	ListaDeItems criarListaDeItems(Object[] lista);
}
