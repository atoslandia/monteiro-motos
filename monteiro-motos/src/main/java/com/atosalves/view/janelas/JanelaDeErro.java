package com.atosalves.view.janelas;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.util.Tema;
import javax.swing.JFrame;

public class JanelaDeErro extends Janela {

	private ComponentesFactory fabrica;

	public JanelaDeErro(String menssagemDeErro) {
		super();
		fabrica = new ComponentesFactory();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		setLayout(null);
		setSize(350, 150);
		setTitle("ALGO DEU ERRADO");
		setVisible(true);
		setLocationRelativeTo(null);

		menssagemDeErro(menssagemDeErro);
	}

	private void menssagemDeErro(String menssagemDeErro) {
		var texto = fabrica.criarTexto(menssagemDeErro, Tema.FONTE_FORTE);
		texto.setBounds(0, 0, 300, 100);
		add(texto);
	}
}
