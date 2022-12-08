package projeto_poo.diversos;

import javax.swing.ImageIcon;

public class ComponentesEstaticos {
	
	public static TextoImagemPadrao fundoPadrao() {
		TextoImagemPadrao fundoPadrao = new TextoImagemPadrao(new ImageIcon("imgs/fundo-padrao.png"));
		fundoPadrao.setBounds(15, -7, 768, 406);
		return fundoPadrao;
	}
}
