package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoMenos extends BotaoPadrao{
	public BotaoMenos() {
		setToolTipText("Clique para diminuir");
		setIcon(new ImageIcon("imgs/botao-menos.png"));
		setPressedIcon(new ImageIcon("imgs/botao-menosclicado.png"));
		setBounds(30, 170, 42, 42);
	}
}
