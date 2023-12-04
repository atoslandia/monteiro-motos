package com.atosalves.view.janelas;

import javax.swing.JOptionPane;

public class JanelaDeErro extends Janela {

	public JanelaDeErro(String mensagem) {
		JOptionPane.showMessageDialog(this, mensagem);
	}
}
