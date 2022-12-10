package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoSolicitar extends BotaoPadrao{
	public BotaoSolicitar() {
		setToolTipText("Clique para solicitar corrida");
		setIcon(new ImageIcon("imgs/passageiro/botao-solicitar.png"));
		setPressedIcon(new ImageIcon("imgs/passageiro/botao-solicitarclicado.png"));
		setBounds(530, 120, 170, 42);
	}
}
