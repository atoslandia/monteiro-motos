package com.atosalves.view.componentes;

import java.awt.Font;
import javax.swing.JLabel;

public class Texto extends JLabel {

	public Texto(String texto, Font fonte) {
		setText(texto);
		setFont(fonte);
	}
}
