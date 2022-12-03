package projeto_poo.componentes;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BotaoPadrao extends JButton{
	public BotaoPadrao(String descricao, String imgNormal, String imgClicada) {
		setToolTipText(descricao);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setIcon(new ImageIcon(imgNormal));
		setPressedIcon(new ImageIcon(imgClicada));
	}
}
