package com.atosalves.view.componentes;

import com.atosalves.view.exception.CampoInvalidoException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class NumeroCaixa extends TextoCaixa {

	@Override
	public String pegarCampo() throws CampoInvalidoException {
		String texto = getText();
		return texto;
	}

	public NumeroCaixa() {
		super();
		setToolTipText("Caracteres permitidos: números");
		addKeyListener(
			new KeyListener() {
				public void keyTyped(KeyEvent e) {
					char t = e.getKeyChar();
					if (!Character.isDigit(t)) e.consume();
				}

				public void keyPressed(KeyEvent e) {}

				public void keyReleased(KeyEvent e) {}
			}
		);
	}
}
