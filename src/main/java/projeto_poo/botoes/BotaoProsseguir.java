package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoProsseguir extends BotaoPadrao{
	public BotaoProsseguir() {
		super();
		setToolTipText("Clique para prosseguir");
		setIcon(new ImageIcon("imgs/botao-prosseguir.png"));
		setPressedIcon(new ImageIcon("imgs/botao-prosseguirclicado.png"));
		setBounds(530, 170, 170, 41);
	}
}
