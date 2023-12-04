package com.atosalves.view.componentes;

import com.atosalves.view.exception.CampoInvalidoException;
import javax.swing.JTextField;

public class TextoCaixa extends JTextField implements ComponenteCaixa {

	@Override
	public String pegarCampo() throws CampoInvalidoException {
		String texto = getText();
		if (texto.length() < 2) {
			throw new CampoInvalidoException();
		}
		return texto;
	}
}
