package projeto_poo.caixas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CaixaCEPNumero extends CaixaTextoPadrao{
	public CaixaCEPNumero() {
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isLetterOrDigit(c)) {
					e.consume();
				}
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}		
		});
	}
}