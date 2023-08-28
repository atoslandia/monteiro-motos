package com.atosalves.view;

import com.atosalves.view.abstractfactory.ComponentesFactory;
import com.atosalves.view.builder.ConstrutorPainel;
import java.awt.GridLayout;
import javax.swing.JPanel;

public abstract class PainelPadrao extends JPanel {

	private GridLayout layout;
	protected ComponentesFactory fabrica;
	protected ConstrutorPainel construtor;

	public PainelPadrao() {
		layout = new GridLayout(0, 2, 5, 5);
		fabrica = new ComponentesFactory();
		construtor = new ConstrutorPainel(this);
		setLayout(layout);
	}

	public abstract void construirComponentes();
}
