package com.atosalves.view.janelas;

import com.atosalves.view.JanelaPadrao;
import com.atosalves.view.paineis.InicioPainel;

public class InicioJanela extends JanelaPadrao {

	public InicioJanela() {
		setTitle("Inicio");
		add(new InicioPainel());
		setVisible(true);
	}
}
