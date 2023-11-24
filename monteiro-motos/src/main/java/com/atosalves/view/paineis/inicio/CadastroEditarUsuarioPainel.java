package com.atosalves.view.paineis.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.builder.PainelBuilderImpl;
import com.atosalves.view.componentes.*;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;
import java.time.LocalDate;

public class CadastroEditarUsuarioPainel extends PainelPadrao {

	private TextoCaixa nomeCaixa;
	private TextoCaixa emailCaixa;
	private SenhaCaixa senhaCaixa;
	private DataCaixa dataCaixa;
	private TipoUsuarioCombo comboBox;

	private Botao cadastroBotao;
	private Botao voltarBotao;

	public CadastroEditarUsuarioPainel() {
		setFundo(Tema.FUNDO_LOGIN);
		cadastro();
		voltar();
	}

	private void cadastro() {
		cadastroBotao.aoClicar(() -> {
			var controller = new UsuarioController();

			if (controller.cadastrar(data())) {
				// TODO: abrir menu
			} else {}
		});
	}

	private void voltar() {
		voltarBotao.aoClicar(() -> {
			setPainel(new LoginPainel());
		});
	}

	private CadastroDTO data() {
		String nome = nomeCaixa.pegarCampo();
		String email = emailCaixa.pegarCampo();
		String senha = senhaCaixa.pegarCampo();
		LocalDate data = dataCaixa.pegarCampo();
		TiposUsuario combo = comboBox.pegarSelecionado();

		return new CadastroDTO(nome, email, senha, data, combo);
	}

	@Override
	protected void inicializarComponentes(ComponentesFactory fabrica) {
		this.nomeCaixa = fabrica.criarCaixaTexto();
		this.emailCaixa = fabrica.criarCaixaTexto();
		this.senhaCaixa = fabrica.criarCaixaSenha();
		this.dataCaixa = fabrica.criarDataCaixa();
		this.comboBox = fabrica.criarComboTipoUsuario();
		this.cadastroBotao = fabrica.criarBotao("CADASTRO");
		this.voltarBotao = fabrica.criarBotao("VOLTAR");
	}

	@Override
	protected PainelPadrao montarComponentes(PainelBuilderImpl builder) {
		return builder
			.setTexto("CADASTRE-SE", Tema.FONTE_MUITO_FORTE)
			.setTextoCaixa("NOME ", nomeCaixa)
			.setTextoCaixa("EMAIL ", emailCaixa)
			.setSenhaCaixa(senhaCaixa)
			.setDataCaixa(dataCaixa)
			.setTipoUsuarioCombo(comboBox)
			.setBotao(cadastroBotao)
			.setBotao(voltarBotao)
			.construir();
	}
}
