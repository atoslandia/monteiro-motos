package com.atosalves.view.paineis;

import java.awt.CardLayout;
import javax.swing.JPanel;
import lombok.Getter;

public class PainelInterno extends JPanel {

	@Getter
	private CardLayout exibirPainel;

	public PainelInterno() {
		exibirPainel = new CardLayout();
		setLayout(exibirPainel);
	}
}
