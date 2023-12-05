package com.atosalves.view.janelas;

import com.atosalves.view.util.Tema;
import javax.swing.JFrame;

public abstract class Janela extends JFrame {

	public Janela() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Tema.ICONE);
	}
}
