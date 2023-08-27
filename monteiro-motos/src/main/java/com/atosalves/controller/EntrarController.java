package com.atosalves.controller;

import com.atosalves.view.PainelPadrao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntrarController implements ActionListener {

	public PainelPadrao painel;

	public EntrarController(PainelPadrao painel) {
		this.painel = painel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
}
