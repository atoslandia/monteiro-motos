package com.atosalves.view.janelas;

import com.atosalves.view.paineis.Painel;
import javax.swing.JFrame;

public class JanelaPrincipal extends Janela {

	public JanelaPrincipal(Painel painelInicial) {
		super();
		setSize(768, 412);
		setTitle("MONTEIRO MOTOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setPainel(painelInicial);

		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void setPainel(Painel painel) {
		getContentPane().removeAll();
		getContentPane().add(painel);
		revalidate();
		repaint();
	}
}
