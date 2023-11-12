package com.atosalves.view.janelas;

import com.atosalves.view.paineis.PainelPadrao;
import javax.swing.JFrame;

public class Janela extends JFrame {

	public Janela(PainelPadrao painel) {
		setSize(768, 412);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MONTEIRO MOTOS");
		setVisible(true);
		setPainel(painel);
	}

	public void setPainel(PainelPadrao painel) {
		getContentPane().removeAll();
		getContentPane().add(painel);
		revalidate();
		repaint();
	}
}
