package com.atosalves.view.janelas;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;

public class JanelaDeErro extends Janela {

	private ComponentesFactory fabrica;

	public JanelaDeErro(String menssagemDeErro) {
		super();
		fabrica = new ComponentesFactory();

		menssagemDeErro(menssagemDeErro);

		setLayout(null);
		setSize(350, 150);
		setTitle("ALGO DEU ERRADO");
		setVisible(true);
		setLocationRelativeTo(null);
	}

	private void menssagemDeErro(String menssagemDeErro) {
		var texto = fabrica.criarTexto(menssagemDeErro);
		texto.setBounds(0, 0, 300, 100);
		add(texto);
	}
}
