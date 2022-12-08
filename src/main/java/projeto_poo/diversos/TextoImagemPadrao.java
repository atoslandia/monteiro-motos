package projeto_poo.diversos;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class TextoImagemPadrao extends JLabel{
	
	public TextoImagemPadrao(String texto) {
		setText(texto);
		setFont(getFont());
	}
	
	public TextoImagemPadrao(ImageIcon imagem) {
		setIcon(imagem);
	}

}
