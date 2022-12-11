package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoBloquear extends BotaoPadrao{
	public BotaoBloquear() {
		setIcon(new ImageIcon("imgs/passageiro/botao-bloquear.png"));
		setPressedIcon(new ImageIcon("imgs/passageiro/botao-bloquearclicado.png"));
		setBounds(48, 240, 134, 50);
	}
}
