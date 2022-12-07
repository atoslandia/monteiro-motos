package projeto_poo.componentes;

import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PainelEsqueciSenha extends PainelPadrao {
	private JButton botaoProsseguir;
	private JButton botaoVoltar;
	
	public PainelEsqueciSenha(ActionListener ouvinteProsseguir, ActionListener ouvinteVoltar) {
		super();
		botaoProsseguir(ouvinteProsseguir);
		botaoVoltar(ouvinteVoltar);
		add(ComponentesEstaticos.fundoPadrao());
	}
	
	private void botaoVoltar(ActionListener ouvinte) {
		botaoVoltar = new BotaoVoltar();
		botaoVoltar.setBounds(558, 220, 58, 22);
		botaoVoltar.addActionListener(ouvinte);
		add(botaoVoltar);
	}
	private void botaoProsseguir(ActionListener ouvinte) {
		botaoProsseguir = new BotaoProsseguir();
		botaoProsseguir.setBounds(500, 155, 170, 41);
		botaoProsseguir.addActionListener(ouvinte);
		add(botaoProsseguir);
	}

	public JButton getBotaoProsseguir() {
		return botaoProsseguir;
	}

	public void setBotaoProsseguir(JButton botaoProsseguir) {
		this.botaoProsseguir = botaoProsseguir;
	}

	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}

	public void setBotaoVoltar(JButton botaoVoltar) {
		this.botaoVoltar = botaoVoltar;
	}
	
	
	
}
