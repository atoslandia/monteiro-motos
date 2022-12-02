package projeto_poo.janelas;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoPadrao extends JButton{
	public BotaoPadrao(String descricao) {
		setToolTipText(descricao);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
}
