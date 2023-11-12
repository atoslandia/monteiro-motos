package com.atosalves.view.paineis.inicio;

import com.atosalves.controller.UsuarioController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.menu.InicioMenuPainel;
import com.atosalves.view.util.Tema;

public class LoginPainel extends PainelPadrao {

	private CaixaTextoComponente email;
	private CaixaSenhaComponente senha;
	private TipoUsuarioCombo combo;

	private BotaoComponente entrar;
	private BotaoComponente cadastrar;

	public LoginPainel() {
		setFundo(Tema.FUNDO_LOGIN);
		entrar();
		cadastrar();
	}

	private void entrar() {
		entrar.aoClicar(() -> {
			var controller = new UsuarioController();

			if (controller.login(data())) {
				setPainel(new InicioMenuPainel());
			} else {
				// TODO: janela de erro
			}
		});
	}

	private void cadastrar() {
		cadastrar.aoClicar(() -> {
			var cadastro = new CadastroEditarUsuarioPainel();
			setPainel(cadastro);
		});
	}

	private LoginDTO data() {
		System.out.println(email.pegarCampo());
		System.out.println(senha.pegarCampo());

		return new LoginDTO(email.pegarCampo(), senha.pegarCampo());
	}

	@Override
	protected void construirComponentes() {
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuario.values());
		this.entrar = fabrica.criarBotao();
		this.cadastrar = fabrica.criarBotao();

		construtor
			.texto("MONTEIRO MOTOS", Tema.FONTE_MUITO_FORTE)
			.caixaTexto("EMAIL:", email)
			.senhaCaixa("SENHA:", senha)
			.comboBox(combo)
			.botao("ENTRAR", entrar)
			.botao("CADASTRAR", cadastrar)
			.construir();
	}
}
