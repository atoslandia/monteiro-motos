package com.atosalves.view;

import com.atosalves.view.paineis.PainelPadrao;

public class JanelaPrincipal extends JanelaPadrao {

	public JanelaPrincipal(PainelPadrao primeiroPainel) {
		setTitle("MONTEIRO MOTOS");
		add(primeiroPainel);
		primeiroPainel.setVisible(true);
		setVisible(true);
	}
}
