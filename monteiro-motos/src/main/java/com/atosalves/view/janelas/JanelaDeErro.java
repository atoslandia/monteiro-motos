package com.atosalves.view.janelas;

import javax.swing.JOptionPane;

public class JanelaDeErro extends Janela {

	public JanelaDeErro(Exception exception) {
		JOptionPane.showMessageDialog(this, exception.getMessage());
	}
}
