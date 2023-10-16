package com.atosalves.view.paineis.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.PainelPadrao;
import lombok.Getter;

public class CadastroEditarUsuarioPainel extends PainelPadrao {

	@Getter
	private CaixaTexto nome;

	@Getter
	private CaixaTexto email;

	@Getter
	private CaixaSenha senha;

	@Getter
	private TipoUsuarioCombo combo;

	private Botao cadastro;
	private Botao voltar;

	public CadastroEditarUsuarioPainel() {
		cadastro();
		voltar();
	}

	private void cadastro() {
		cadastro.aoClicar(() -> {
			var controller = new UsuarioController();

			if (controller.cadastrar(data())) {
				// TODO abrir menu
			} else {
				// TODO janela de erro
			}
		});
	}

	private void voltar() {
		voltar.aoClicar(() -> {
			setPainel(new LoginPainel());
		});
	}

	private CadastroDTO data() {
		return new CadastroDTO(
			nome.pegarCampo(),
			email.pegarCampo(),
			senha.pegarCampo()
		);
	}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("NOME: ", nome)
			.caixaTexto("EMAIL:", email)
			.senhaCaixa("SENHA:", senha)
			.comboBox(combo)
			.botao("CADASTRAR", cadastro)
			.botao("VOLTAR", voltar)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.nome = fabrica.criarCaixaTexto();
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuario.values());
		this.cadastro = fabrica.criarBotao();
		this.voltar = fabrica.criarBotao();
	}
}
