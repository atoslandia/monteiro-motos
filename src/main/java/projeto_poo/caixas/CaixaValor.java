package projeto_poo.caixas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CaixaValor extends CaixaTextoPadrao{
	public CaixaValor() {
		setToolTipText("Caracteres permitidos: números, '.'");
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
				char t = e.getKeyChar(); 
				if(!Character.isDigit(t) && t != '.')
					e.consume();
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
	}
}
