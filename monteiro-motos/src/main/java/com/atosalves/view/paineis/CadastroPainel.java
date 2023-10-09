package com.atosalves.view.paineis;

import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.Botao;
import com.atosalves.view.componentes.SenhaCaixa;
import com.atosalves.view.componentes.TextoCaixa;
import com.atosalves.view.componentes.TipoUsuarioCombo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroPainel extends PainelPadrao {

	private TextoCaixa nome;
	private TextoCaixa email;
	private SenhaCaixa senha;
	private TipoUsuarioCombo combo;

	private Botao cadastro;
	private Botao voltar;

	public CadastroPainel() {}

	private void cadastroOuvinte() {
		cadastro.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {}
			}
		);
	}

	@Override
	protected void construirComponentes() {
		construtor
			.caixaTexto("NOME", nome)
			.caixaTexto("EMAIL", email)
			.senhaCaixa("SENHA", senha)
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
