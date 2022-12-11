package administrador;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import projeto_poo.botoes.BotaoMais;
import projeto_poo.botoes.BotaoMenos;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaValorCreditoReinvidicacao extends JanelaPadrao{
	
	private TextoImagemPadrao numero;
	private float valor = 0;
	
	public JanelaValorCreditoReinvidicacao() {
		super("Defina um valor para os créditos de reinvidicação");
		caixaValor();
		botoes();
		add(getFundoPadrao());
		setVisible(true);
	}
	
	private void botoes() {
		BotaoMenos menos = new BotaoMenos();
		add(menos);
		
		BotaoMais mais = new BotaoMais();
		mais.addActionListener(new OuvinteMais());
		add(mais);
		
	}
	
	private void caixaValor() {
		numero = new TextoImagemPadrao(Float.toString(valor));
		numero.setBounds(90, 100, 100, 100);
		numero.setFont(new Font("Calibrii", Font.BOLD, 35));
		
		add(numero);
	}
	
	private class OuvinteMais implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(valor >= 0 && valor < 5)
				numero.setText(Float.toString(valor += 0.5f));
		}
		
	}
	
	public static void main(String[] args) {
		new JanelaValorCreditoReinvidicacao();
	}
	
}
