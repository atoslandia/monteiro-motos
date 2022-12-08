package projeto_poo.caixas;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;

import projeto_poo.erros.CaixaVaziaException;

public class CaixaCodigo extends CaixaTextoPadrao{
	public CaixaCodigo() {
		super();
		setToolTipText("Caracteres permitidos: números");
		addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e) {
				char t = e.getKeyChar(); 
				if(!Character.isDigit(t))
					e.consume();
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
	}
	
	public void comparar(String c) throws CaixaVaziaException {
		if(super.getText().equals("") | !super.getText().equals(c)) {
			setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.RED));
			throw new CaixaVaziaException();
		}
	}
}
