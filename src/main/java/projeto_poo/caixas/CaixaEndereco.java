package projeto_poo.caixas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CaixaEndereco extends CaixaTextoPadrao {
	public CaixaEndereco() {
		
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!Character.isAlphabetic(c) && c != ' ' && c != '-' && c != '.') {
					e.consume();
				}
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}		
		});
	}
}
