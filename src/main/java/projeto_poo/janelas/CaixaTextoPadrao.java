package projeto_poo.janelas;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class CaixaTextoPadrao extends JTextField{
	
	public CaixaTextoPadrao() {
		setSelectionColor(new Color(255, 204, 0));
		setFont(getFont());
		setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
	}
}
