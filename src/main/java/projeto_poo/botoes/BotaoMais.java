package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoMais extends BotaoPadrao{
	public BotaoMais() {
		setToolTipText("Clique para aumentar");
		setIcon(new ImageIcon("imgs/botao-mais.png"));
		setPressedIcon(new ImageIcon("imgs/botao-maisclicado.png"));
		setBounds(160, 170, 41, 41);
	}
}
