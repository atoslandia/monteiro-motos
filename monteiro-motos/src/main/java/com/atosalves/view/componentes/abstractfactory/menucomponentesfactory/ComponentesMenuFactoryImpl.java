package com.atosalves.view.componentes.abstractfactory.menucomponentesfactory;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.BotaoMenu;
import com.atosalves.view.componentes.DataCaixa;
import com.atosalves.view.componentes.EmailCaixa;
import com.atosalves.view.componentes.ListaDeCorridas;
import com.atosalves.view.componentes.NumeroCaixa;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.Texto;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import com.atosalves.view.componentes.abstractfactory.ComponentesFactory;
import java.awt.Font;

public class ComponentesMenuFactoryImpl implements ComponentesFactory {

	@Override
	public SenhaCaixa criarCaixaSenha() {
		throw new UnsupportedOperationException("Unimplemented method 'criarCaixaSenha'");
	}

	@Override
	public TextoCaixa criarCaixaTexto() {
		throw new UnsupportedOperationException("Unimplemented method 'criarCaixaTexto'");
	}

	@Override
	public Texto criarTexto(String texto, Font fonte) {
		throw new UnsupportedOperationException("Unimplemented method 'criarTexto'");
	}

	@Override
	public DataCaixa criarDataCaixa() {
		throw new UnsupportedOperationException("Unimplemented method 'criarDataCaixa'");
	}

	@Override
	public TipoUsuarioCombo criarComboTipoUsuario() {
		throw new UnsupportedOperationException("Unimplemented method 'criarComboTipoUsuario'");
	}

	@Override
	public Botao criarBotao(String titulo) {
		return new BotaoMenu(titulo);
	}

	@Override
	public ListaDeCorridas criarListaDeItems(CorridaDTO[] lista) {
		throw new UnsupportedOperationException("Unimplemented method 'criarListaDeItems'");
	}

	@Override
	public EmailCaixa criarEmailCaixa() {
		throw new UnsupportedOperationException("Unimplemented method 'emailCaixa'");
	}

	@Override
	public NumeroCaixa criarNumeroCaixa() {
		throw new UnsupportedOperationException("Unimplemented method 'criarNumeroCaixa'");
	}
}
