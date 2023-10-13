package com.atosalves.view.paineis;

import com.atosalves.view.paineis.menu.CorridasPainel;
import com.atosalves.view.paineis.menu.EditarPainel;
import com.atosalves.view.paineis.menu.InicioPainel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import lombok.Getter;

public class ShowMenuPainel extends JPanel {

	@Getter
	private CardLayout exibirPainel;

	private InicioPainel inicio;
	private CorridasPainel corridas;
	private EditarPainel editar;

	public ShowMenuPainel() {
		exibirPainel = new CardLayout();

		inicio = new InicioPainel();
		corridas = new CorridasPainel();
		editar = new EditarPainel();

		// inicio.paintComponents();

		setLayout(exibirPainel);

		add(inicio, "INICIO");
		add(corridas, "CORRIDAS");
		add(editar, "EDITAR");
	}
}
