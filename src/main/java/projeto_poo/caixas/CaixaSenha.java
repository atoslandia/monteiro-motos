package projeto_poo.caixas;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

import projeto_poo.erros.CaixaVaziaException;

public class CaixaSenha extends JPasswordField{
	
	public CaixaSenha() {
		setSelectionColor(new Color(255, 204, 0));
		setFont(getFont());
		setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
		setToolTipText("Mínimo 4 caracteres, permitidos: letras, números, '@', '_', '.', '-', '+'");
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
	
	public String pegarConteudo() throws CaixaVaziaException {
		if(new String(super.getPassword()).equals("") && new String(super.getPassword()).length() < 3) {
			setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.RED));
			throw new CaixaVaziaException();
		}
		return new String(super.getPassword());
	}
	
}
