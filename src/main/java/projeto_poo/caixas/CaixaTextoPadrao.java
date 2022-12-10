package projeto_poo.caixas;

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
	
	public String pegarConteudo() throws CaixaVaziaException{
			if(super.getText().equals("")) {
				setBorder(BorderFactory.createMatteBorder(2,2,2,2, Color.RED));
				throw new CaixaVaziaException();
			}
			return super.getText();
	}
	
}
