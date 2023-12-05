package com.atosalves.view.janelas;

import javax.swing.JOptionPane;

public class JanelaDeAviso extends Janela {

	public JanelaDeAviso(String aviso) {
		JOptionPane.showMessageDialog(this, aviso);
	}
}
