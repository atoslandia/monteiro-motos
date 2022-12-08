package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoConcluir extends BotaoPadrao{
	public BotaoConcluir() {
		super();
		setToolTipText("Clique para concluir");
		setIcon(new ImageIcon("imgs/botao-concluir.png"));
		setPressedIcon(new ImageIcon("imgs/botao-concluirclicado.png"));
		setBounds(530, 170, 170, 41);
	}
}
