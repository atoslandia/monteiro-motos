package com.atosalves.view.componentes;

import com.atosalves.view.util.Tema;
import javax.swing.JLabel;

public class Texto extends JLabel {

	public Texto(String texto) {
		setFont(Tema.TEXTO_FONTE);
		setText(texto);
	}
}
