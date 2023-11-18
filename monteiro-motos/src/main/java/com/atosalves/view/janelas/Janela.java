package com.atosalves.view.janelas;

import javax.swing.JFrame;

public abstract class Janela extends JFrame {

	public Janela() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
