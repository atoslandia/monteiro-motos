package com.atosalves.view.paineis.factorymethod.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.*;
import com.atosalves.view.exception.CampoInvalidoException;
import com.atosalves.view.janelas.JanelaDeAviso;
import com.atosalves.view.janelas.JanelaDeErro;
import com.atosalves.view.paineis.factorymethod.PainelTemplate;
import com.atosalves.view.paineis.factorymethod.menu.MenuPainel;
import com.atosalves.view.paineis.painelbuilder.PainelBuilderImpl;
import com.atosalves.view.util.Tema;

public class CadastroUsuarioPainel extends PainelTemplate {

	private TextoCaixa nomeCaixa;
	private EmailCaixa emailCaixa;
	private SenhaCaixa senhaCaixa;
	private DataCaixa dataCaixa;
	private TipoUsuarioCombo comboBox;

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
			LoginDTO loginDTO = new LoginDTO(emailCaixa.pegarCampo(), senhaCaixa.pegarCampo(), comboBox.pegarSelecionado());

			new JanelaDeAviso(loginDTO);

			UsuarioController usuarioController = new UsuarioController();
			usuarioController.cadastrar(getDados());

			painel.setPainel(new MenuPainel(loginDTO).criarPainel());
		} catch (RuntimeException r) {
			new JanelaDeErro(r);
		} catch (Exception e) {
			new JanelaDeErro(e);
		}
	}

	private void voltarBotao() {
		painel.setPainel(new LoginPainel().criarPainel());
	}

	@Override
	public void inicializarComponentes() {
		this.nomeCaixa = COMPONENTES_FACTORY.criarCaixaTexto();
		this.emailCaixa = COMPONENTES_FACTORY.criarEmailCaixa();
		this.senhaCaixa = COMPONENTES_FACTORY.criarCaixaSenha();
		this.dataCaixa = COMPONENTES_FACTORY.criarDataCaixa();
		this.comboBox = COMPONENTES_FACTORY.criarComboTipoUsuario();
	}

	@Override
	public void construirPainel() {
		painel =
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
}
