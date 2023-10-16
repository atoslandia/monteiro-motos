package com.atosalves.view.paineis.menu;

import com.atosalves.view.paineis.PainelInterno;

public class MenuPainelInterno extends PainelInterno {

	private InicioPainel inicio;
	private CorridasPainel corridas;
	private EditarPainel editar;

	public MenuPainelInterno() {
		inicio = new InicioPainel();
		corridas = new CorridasPainel();
		editar = new EditarPainel();

		add(inicio, "INICIO");
		add(corridas, "CORRIDAS");
		add(editar, "EDITAR");
	}
}
