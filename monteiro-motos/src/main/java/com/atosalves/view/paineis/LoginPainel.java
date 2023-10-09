package com.atosalves.view.paineis;

import com.atosalves.controller.LoginController;
import com.atosalves.dto.LoginDTO;
import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPainel extends PainelPadrao {

	private TextoCaixa email;

	private SenhaCaixa senha;
	private TipoUsuarioCombo combo;

	private Botao entrar;
	private Botao cadastrar;

	public LoginPainel() {
		entrarOuvinte();
		cadastrarOuvinte();
	}

	private void entrarOuvinte() {
		entrar.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					var controller = new LoginController();

					if (controller.login(data())) {
						proximoPainel(new MenuPainel());
					} else {
						// TODO janela de erro
					}
				}
			}
		);
	}

	private LoginDTO data() {
		return new LoginDTO(email.pegarCampo(), senha.pegarCampo());
	}

	private void cadastrarOuvinte() {
		cadastrar.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					proximoPainel(new CadastroPainel());
				}
			}
		);
	}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("email", email)
			.senhaCaixa("senha", senha)
			.comboBox(combo)
			.botao("ENTRAR", entrar)
			.botao("CADASTRAR", cadastrar)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.email = fabrica.criarCaixaTexto();
		this.senha = fabrica.criarCaixaSenha();
		this.combo = fabrica.criarComboTipoUsuario(TiposUsuario.values());
		this.entrar = fabrica.criarBotao();
		this.cadastrar = fabrica.criarBotao();
	}
}
