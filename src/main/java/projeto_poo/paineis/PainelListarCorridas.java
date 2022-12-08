package projeto_poo.paineis;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.diversos.TextoImagemPadrao;

public class PainelListarCorridas extends PainelPadrao{
	
	public PainelListarCorridas() {
		super();
	}
	
	private void barraListarCorridas() {
        JLabel fundoLogin = new TextoImagemPadrao(new ImageIcon("imgs/fundo-botaoinicio.png"));
        fundoLogin.setBounds(15, -7, 768, 406);
        add(fundoLogin);
	}
}
