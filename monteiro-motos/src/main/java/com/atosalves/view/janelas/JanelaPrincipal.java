package com.atosalves.view.janelas;

import com.atosalves.view.paineis.PainelPadrao;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame {

	public JanelaPrincipal(PainelPadrao painel) {
		super();
		setSize(768, 412);
		setTitle("MONTEIRO MOTOS");
		setPainel(painel);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void setPainel(PainelPadrao painel) {
		getContentPane().removeAll();
		getContentPane().add(painel);
		revalidate();
		repaint();
	}
}
