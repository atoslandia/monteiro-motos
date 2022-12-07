package projeto_poo.componentes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CaixaNomeSobrenome extends CaixaTextoPadrao{
	public CaixaNomeSobrenome() {
		super();
		setToolTipText("Caracteres permitidos: letras");
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if(!Character.isLetter(e.getKeyChar()))
					e.consume();
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
	}
}
