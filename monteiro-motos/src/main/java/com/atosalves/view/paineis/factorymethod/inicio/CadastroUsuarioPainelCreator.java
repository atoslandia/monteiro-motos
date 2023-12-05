package com.atosalves.view.paineis.factorymethod.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.*;
import com.atosalves.view.exception.CampoInvalidoException;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.PainelCreator;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainelCreator;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CadastroUsuarioPainelCreator implements PainelCreator {

	private TextoCaixa nomeCaixa;
	private TextoCaixa emailCaixa;
	private SenhaCaixa senhaCaixa;
	private DataCaixa dataCaixa;
	private TipoUsuarioCombo comboBox;

	private Painel cadastroPainel;

	private CadastroDTO getDados() throws CampoInvalidoException {
		return new CadastroDTO(
			nomeCaixa.pegarCampo(),
			emailCaixa.pegarCampo(),
			senhaCaixa.pegarCampo(),
			dataCaixa.pegarCampo(),
			comboBox.pegarSelecionado()
		);
	}

	private void cadastrarBotao() {
		try {
			UsuarioController usuarioController = new UsuarioController();
			usuarioController.cadastrar(getDados());

			LoginDTO loginDTO = new LoginDTO(emailCaixa.pegarCampo(), senhaCaixa.pegarCampo(), comboBox.pegarSelecionado());

			cadastroPainel.setPainel(new MenuPainelCreator(loginDTO).criarPainel());
		} catch (Exception e) {
			new JanelaDeErro(e);
		}
	}

	private void voltarBotao() {
		cadastroPainel.setPainel(new LoginPainelCreator().criarPainel());
	}

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
				.setBotao("CADASTRAR", this::cadastrarBotao)
				.setBotao("VOLTAR", this::voltarBotao)
				.construir();
	}

	@Override
	public Painel factoryMethod() {
		return cadastroPainel;
	}
}
