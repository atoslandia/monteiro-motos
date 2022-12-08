package projeto_poo.paineis;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projeto_poo.diversos.TextoImagemPadrao;

public class PainelPadrao extends JPanel{
	
	public PainelPadrao() {
		setLayout(null);
		setSize(760, 420);
	}
	
	private void fundoLogin() {
        JLabel fundoLogin = new TextoImagemPadrao(new ImageIcon("imgs/fundo-padrao.png"));
        fundoLogin.setBounds(15, -7, 768, 406);
        add(fundoLogin);
    }
}
