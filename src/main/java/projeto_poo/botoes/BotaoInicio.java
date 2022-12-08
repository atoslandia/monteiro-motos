package projeto_poo.botoes;

import javax.swing.ImageIcon;

public class BotaoInicio extends BotaoPadrao{
	public BotaoInicio() {
		super();
		setToolTipText("Clique para retornar para o inicio");
		setIcon(new ImageIcon("imgs/botao-inicio.png"));
		setBounds(530, 170, 170, 41);
	}
}
