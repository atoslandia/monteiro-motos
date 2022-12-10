package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoDetalhar extends BotaoPadrao{
	public BotaoDetalhar() {
		super();
		setToolTipText("Clique para detalhar");
		setIcon(new ImageIcon("imgs/botao-detalhar.png"));
		setPressedIcon(new ImageIcon("imgs/botao-detalharclicado.png"));
		setBounds(530, 170, 170, 41);
	}
}
