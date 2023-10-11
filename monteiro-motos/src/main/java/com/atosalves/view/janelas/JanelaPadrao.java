package com.atosalves.view.janelas;

import com.atosalves.view.util.Tema;
import javax.swing.JFrame;

public abstract class JanelaPadrao extends JFrame {

	public JanelaPadrao() {
		setSize(768, 412);
		setFont(Tema.TEXTO_FONTE);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MONTEIRO MOTOS");
	}
}
