package com.atosalves.view.componentes;

import java.awt.Font;
import javax.swing.JLabel;

public class Texto extends JLabel implements Componente {

	public Texto(String texto, Font fonte) {
		setText(texto);
		setFont(fonte);
	}
}
