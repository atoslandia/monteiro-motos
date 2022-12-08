package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoVoltar extends BotaoPadrao{
	public BotaoVoltar() {
		super();
		setToolTipText("Clique para voltar");
		setIcon(new ImageIcon("imgs/botao-voltar.png"));
		setPressedIcon(new ImageIcon("imgs/botao-voltarclicado.png"));
		setBounds(590, 220, 58, 22);
	}
}
