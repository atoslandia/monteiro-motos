package projeto_poo.ouvintes;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OuvinteTeclasSenha implements KeyListener{
	private String teclasEspeciais = "Caracteres permitidos: letras, números, '@', '_', '.'";
	
	public void keyTyped(KeyEvent e) {
		char t = e.getKeyChar(); 
		
		if(!Character.isLetter(t) && !Character.isDigit(t) && t != '@' && t != '_' && t != '.')
			e.consume();
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public String getTeclasEspeciais() {
		return teclasEspeciais;
	}
}
