package com.atosalves.view.componentes;

import javax.swing.JTextField;

public class CaixaTextoComponente
	extends JTextField
	implements ComponenteCaixa, Componente {

	@Override
	public String pegarCampo() {
		return getText();
	}
}
