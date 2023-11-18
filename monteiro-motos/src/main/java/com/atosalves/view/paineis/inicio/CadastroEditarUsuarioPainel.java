package com.atosalves.view.paineis.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;

public class CadastroEditarUsuarioPainel extends PainelPadrao {

	private CaixaTexto nome;
	private CaixaTexto email;
	private CaixaSenha senha;
	private TipoUsuarioCombo combo;

	private Botao cadastro;
	private Botao voltar;

	public CadastroEditarUsuarioPainel() {
		setFundo(Tema.FUNDO_LOGIN);
		cadastro();
		voltar();
	}

	private void cadastro() {
		cadastro.aoClicar(() -> {
			var controller = new UsuarioController();

			if (controller.cadastrar(data())) {
				// TODO: abrir menu
			} else {
				// TODO: janela de erro
			}
		});
	}

	private void voltar() {
		voltar.aoClicar(() -> {
			setPainel(new LoginPainel());
		});
	}

	private CadastroDTO data() {
		return new CadastroDTO(nome.pegarCampo(), email.pegarCampo(), senha.pegarCampo());
	}

	@Override
	protected void construirComponentes() {
		this.nome = fabrica.criarCaixaTexto();
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario();
		this.cadastro = fabrica.criarBotao();
		this.voltar = fabrica.criarBotao();

		construtor
			.texto("CADASTRE-SE", Tema.FONTE_MUITO_FORTE)
			.caixaTexto("NOME: ", nome)
			.caixaTexto("EMAIL:", email)
			.senhaCaixa("SENHA:", senha)
			.comboBox(combo)
			.botao("CADASTRAR", cadastro)
			.botao("VOLTAR", voltar)
			.construir();
	}
}
