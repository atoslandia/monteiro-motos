package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoListarCorridas extends BotaoPadrao{
	public BotaoListarCorridas() {
		super();
		setToolTipText("Clique para listar corridas");
		setIcon(new ImageIcon("imgs/botao-listarcorridas.png"));
		setBounds(231, 343, 298, 26);
	}
}
