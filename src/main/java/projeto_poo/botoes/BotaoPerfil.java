package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoPerfil extends BotaoPadrao{
	public BotaoPerfil() {
		super();
		setToolTipText("Clique para ver opções do seu perfil");
		setIcon(new ImageIcon("imgs/botao-perfil.png"));
		setBounds(580, 344, 116, 25);
	}
}
