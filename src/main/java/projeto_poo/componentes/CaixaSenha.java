package projeto_poo.componentes;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class CaixaSenha extends JPasswordField{
	
	public CaixaSenha() {
		setSelectionColor(new Color(255, 204, 0));
		setFont(getFont());
		setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
		setToolTipText("Caracteres permitidos: letras, números, '@', '_', '.', '-', '+'");
		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				char t = e.getKeyChar(); 
				if(!Character.isLetterOrDigit(t) && t != '@' && t != '_' && t != '.' && t != '-' && t != '+')
					e.consume();
			}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
		});
	}
}
