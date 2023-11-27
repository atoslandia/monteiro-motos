package com.atosalves.view.paineis.inicio;

import com.atosalves.view.componentes.*;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import com.atosalves.view.paineis.ConstrutorPainel;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class LoginPainel extends ConstrutorPainel {

	public LoginPainel(ComponentesFactoryImpl factory) {
		super(factory);
	}

	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo tipoUsuarioCombo;

	@Override
	protected void inicializarComponentes() {
		ComponentesFactoryImpl factory = getFactory();

		this.email = factory.criarCaixaTexto();
		this.senha = factory.criarCaixaSenha();
		this.tipoUsuarioCombo = factory.criarComboTipoUsuario();
	}

	@Override
	public Painel construirPainel() {
		return new PainelBuilderImpl()
			.setImagem(Tema.FUNDO_LOGIN)
			.setTexto("MONTEIRO MOTOS", Tema.FONTE_MUITO_FORTE)
			.setTextoCaixa("EMAIL", email)
			.setSenhaCaixa(senha)
			.setTipoUsuarioCombo(tipoUsuarioCombo)
			.setBotao("LOGIN")
			.setBotao("CADASTRO")
			.construir();
	}
}
