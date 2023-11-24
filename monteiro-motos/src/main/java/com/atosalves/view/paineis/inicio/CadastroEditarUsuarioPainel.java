package com.atosalves.view.paineis.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.CadastroDTO;
import com.atosalves.view.builder.PainelBuilderImpl;
import com.atosalves.view.componentes.*;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;

public class CadastroEditarUsuarioPainel extends PainelPadrao {

	private TextoCaixa nome;
	private TextoCaixa email;
	private SenhaCaixa senha;
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
		return null;
	}

	@Override
	protected void inicializarComponentes(ComponentesFactory fabrica) {
		this.nome = fabrica.criarCaixaTexto();
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario();
		this.cadastro = fabrica.criarBotao("CADASTRO");
		this.voltar = fabrica.criarBotao("VOLTAR");
	}

	@Override
	protected PainelPadrao montarComponentes(PainelBuilderImpl builder) {
		return builder
			.setTexto("CADASTRE-SE", Tema.FONTE_MUITO_FORTE)
			.setTextoCaixa("NOME ", nome)
			.setTextoCaixa("EMAIL ", email)
			.setSenhaCaixa(senha)
			.setTipoUsuarioCombo(combo)
			.setBotao(cadastro)
			.setBotao(voltar)
			.construir();
	}
}
