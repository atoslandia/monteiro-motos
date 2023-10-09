package com.atosalves.view.componentes;

import javax.swing.JTextField;

public class TextoCaixa extends JTextField implements ComponenteCaixa {

	@Override
	public String pegarCampo() {
		return getText();
	}
}
