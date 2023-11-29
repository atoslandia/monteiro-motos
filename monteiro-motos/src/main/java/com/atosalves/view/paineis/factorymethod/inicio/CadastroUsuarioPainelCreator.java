package com.atosalves.view.paineis.factorymethod.inicio;

import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.InicioMenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CadastroUsuarioPainelCreator implements PainelCreator {

	private TextoCaixa nomeCaixa;
	private TextoCaixa emailCaixa;
	private SenhaCaixa senhaCaixa;
	private DataCaixa dataCaixa;
	private TipoUsuarioCombo comboBox;

	private Painel cadastroPainel;

	@Override
	public void inicializarComponentes() {
		this.nomeCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		this.emailCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		this.senhaCaixa = COMPONENTES_FACTORY.criarCaixaSenha();
		this.dataCaixa = COMPONENTES_FACTORY.criarDataCaixa();
		this.comboBox = COMPONENTES_FACTORY.criarComboTipoUsuario();
	}

	@Override
	public void construirPainel() {
		cadastroPainel =
			new PainelBuilderImpl()
				.setImagem(Tema.FUNDO_CINZA)
				.setTexto("CADASTRO", Tema.FONTE_MUITO_FORTE)
				.setTextoCaixa("NOME", nomeCaixa)
				.setTextoCaixa("EMAIL", emailCaixa)
				.setSenhaCaixa(senhaCaixa)
				.setTipoUsuarioCombo(comboBox)
				.setDataCaixa(dataCaixa)
				.setBotao(
					"CADASTRAR",
					() -> {
						cadastroPainel.setPainel(new InicioMenuPainelCreator().criarPainel());
					}
				)
				.setBotao(
					"VOLTAR",
					() -> {
						cadastroPainel.setPainel(new LoginPainelCreator().criarPainel());
					}
				)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return cadastroPainel;
	}
}
