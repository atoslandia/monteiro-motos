package com.atosalves.view;

import com.atosalves.view.abstractfactory.ComponentesFactory;
import java.awt.GridLayout;
import javax.swing.JPanel;

public abstract class PainelPadrao extends JPanel {

	private GridLayout layout;
	protected ComponentesFactory fabrica;

	public PainelPadrao() {
		layout = new GridLayout(0, 2, 5, 5);
		fabrica = new ComponentesFactory();
		setLayout(layout);
	}

	protected void tornarVisivel() {
		setVisible(true);
	}

	public abstract void construirComponentes();
}
