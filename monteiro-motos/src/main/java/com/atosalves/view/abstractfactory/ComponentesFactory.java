package com.atosalves.view.abstractfactory;

public class ComponentesFactory {

	public SenhaCaixa criarCaixaSenha() {
		return new SenhaCaixa();
	}

	public TextoCaixa criarCaixaTexto() {
		return new TextoCaixa();
	}

	public Texto criarTexto(String texto) {
		return new Texto(texto);
	}

	public TipoUsuarioCombo criarComboTipoUsuario(TiposUsuarios[] tipos) {
		return new TipoUsuarioCombo(tipos);
	}

	public Botao criarBotao(String titulo) {
		return new Botao(titulo);
	}
}
