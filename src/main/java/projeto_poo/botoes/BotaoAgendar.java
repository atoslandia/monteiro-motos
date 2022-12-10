package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoAgendar extends BotaoPadrao{
	public BotaoAgendar() {
		setToolTipText("Clique para solicitar corrida");
		setIcon(new ImageIcon("imgs/passageiro/botao-agendar.png"));
		setPressedIcon(new ImageIcon("imgs/passageiro/botao-agendarclicado.png"));
		setBounds(530, 170, 170, 42);
	}
}
