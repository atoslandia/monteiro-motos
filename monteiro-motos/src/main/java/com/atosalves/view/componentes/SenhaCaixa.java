package com.atosalves.view.componentes;

import com.atosalves.view.exception.CampoInvalidoException;
import javax.swing.JPasswordField;

public class SenhaCaixa extends JPasswordField implements ComponenteCaixa {

	@Override
	public String pegarCampo() throws CampoInvalidoException {
		String texto = new String(getPassword());
		if (texto.length() < 4) {
			throw new CampoInvalidoException();
		}
		return texto;
	}
}
