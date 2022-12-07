package projeto_poo.componentes;

import javax.swing.ImageIcon;

public class BotaoProsseguir extends BotaoPadrao{
	public BotaoProsseguir() {
		super();
		setToolTipText("Clique para prosseguir");
		setIcon(new ImageIcon("imgs/botao-prosseguir.png"));
		setPressedIcon(new ImageIcon("imgs/botao-prosseguirclicado.png"));
	}
}
