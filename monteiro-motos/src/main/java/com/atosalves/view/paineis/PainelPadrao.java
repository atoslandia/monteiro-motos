package com.atosalves.view.paineis;

import com.atosalves.controller.Controller;
import com.atosalves.view.abstractfactory.ComponentesFactory;
import com.atosalves.view.builder.ConstrutorPainel;
import java.awt.GridLayout;
import javax.swing.JPanel;

public abstract class PainelPadrao<T extends Controller> extends JPanel {

	private GridLayout layout;
	protected ComponentesFactory fabrica;
	protected ConstrutorPainel construtor;

	protected T controller;

	public PainelPadrao() {
		layout = new GridLayout(0, 2, 5, 5);
		fabrica = new ComponentesFactory();
		construtor = new ConstrutorPainel(this);
		setLayout(layout);
	}

	protected abstract void construirComponentes();

	public void setController(T controller) {
		this.controller = controller;
	}
}
