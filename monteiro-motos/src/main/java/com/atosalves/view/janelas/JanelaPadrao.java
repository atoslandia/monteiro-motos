package com.atosalves.view.janelas;

import javax.swing.JFrame;

public abstract class JanelaPadrao extends JFrame {

	public JanelaPadrao() {
		setSize(768, 412);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MONTEIRO MOTOS");
	}
}
