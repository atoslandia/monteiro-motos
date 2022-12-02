package projeto_poo.ouvintes;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OuvinteTeclasBloqueadas implements KeyListener{

	private String teclasEspeciais = "Apenas letras são permitidas";
	
	public void keyTyped(KeyEvent e) {
		char t = e.getKeyChar(); 
		
		if(!Character.isLetter(t))
			e.consume();
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public String getTeclasEspeciais() {
		return teclasEspeciais;
	}

}
