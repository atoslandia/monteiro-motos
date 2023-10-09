package com.atosalves.view.janelas;

import com.atosalves.view.paineis.PainelPadrao;

public class JanelaPrincipal extends JanelaPadrao {

	public JanelaPrincipal(PainelPadrao painel) {
		super();
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
