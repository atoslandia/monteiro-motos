package projeto_poo.caixas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import projeto_poo.erros.CaixaVaziaException;

public class CaixaEmail extends CaixaTextoPadrao{
	
	public CaixaEmail() {
		super();
		setToolTipText("Caracteres permitidos: letras, números, '@', '_', '.'");
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
				char t = e.getKeyChar(); 
				if(!Character.isLetterOrDigit(t) && t != '@' && t != '_' && t != '.')
					e.consume();
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
	}
}
