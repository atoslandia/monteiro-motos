package projeto_poo.componentes;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;

public class CaixaPadraoSenha extends JPasswordField{
	public CaixaPadraoSenha() {
		setSelectionColor(new Color(255, 204, 0));
		setFont(getFont());
		setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
	}
}
