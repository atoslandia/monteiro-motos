package com.atosalves.view.paineis.inicio;

import com.atosalves.view.componentes.*;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import com.atosalves.view.paineis.ConstrutorPainel;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CadastroEditarUsuarioPainel extends ConstrutorPainel {

	public CadastroEditarUsuarioPainel(ComponentesFactoryImpl factory) {
		super(factory);
	}

	private TextoCaixa nomeCaixa;
	private TextoCaixa emailCaixa;
	private SenhaCaixa senhaCaixa;
	private DataCaixa dataCaixa;
	private TipoUsuarioCombo comboBox;

	@Override
	public void inicializarComponentes() {
		ComponentesFactoryImpl factory = getFactory();

		this.nomeCaixa = factory.criarCaixaTexto();
		this.emailCaixa = factory.criarCaixaTexto();
		this.senhaCaixa = factory.criarCaixaSenha();
		this.dataCaixa = factory.criarDataCaixa();
		this.comboBox = factory.criarComboTipoUsuario();
	}

	@Override
	public Painel construirPainel() {
		return new PainelBuilderImpl()
			.setImagem(Tema.FUNDO_CINZA)
			.setTexto("CADASTRO", Tema.FONTE_MUITO_FORTE)
			.setTextoCaixa("NOME", nomeCaixa)
			.setTextoCaixa("EMAIL", emailCaixa)
			.setSenhaCaixa(senhaCaixa)
			.setTipoUsuarioCombo(comboBox)
			.setDataCaixa(dataCaixa)
			.setBotao("CADASTRAR")
			.setBotao("VOLTAR")
			.construir();
	}
}
