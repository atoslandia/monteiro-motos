package mototaxista;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoMais;
import projeto_poo.botoes.BotaoMenos;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaComprarCreditosDeReinvidicacao extends JanelaPadrao{
	public JanelaComprarCreditosDeReinvidicacao() {
		super("Comprar créditos de reinvidicação");
		botoes();
		logo();
		add(getFundoPadrao());
		setVisible(true);
	}
	
	private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/mototaxista/comprarcreditos.png"));
			logo.setBounds(30, 22, 436, 40);
			add(logo);
	}
	
	private void textos() {
//		TextoImagemPadrao valorDoCredito = new TextoImagemPadrao("Valor dos créditos de reinvidicação: "+getV)
	}
	
	private void botoes() {
		BotaoMenos menos = new BotaoMenos();
		add(menos);
		
		BotaoMais mais = new BotaoMais();
		add(mais);
		
		BotaoConcluir concluir = new BotaoConcluir();
		add(concluir);
		
		BotaoVoltar voltar = new BotaoVoltar();
		add(voltar);
		
	}
	
}
