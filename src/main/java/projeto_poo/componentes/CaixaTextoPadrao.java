package projeto_poo.componentes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import projeto_poo.erros.CaixaVaziaException;

public class CaixaTextoPadrao extends JTextField{
	
	public CaixaTextoPadrao(){
		setSelectionColor(new Color(255, 204, 0));
		setFont(getFont());
		setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
	}
}
