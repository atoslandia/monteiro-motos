package com.atosalves.view.componentes;

import javax.swing.JPasswordField;

public class CaixaSenha extends JPasswordField implements ComponenteCaixa {

	@Override
	public String pegarCampo() {
		return new String(getPassword());
	}
}
