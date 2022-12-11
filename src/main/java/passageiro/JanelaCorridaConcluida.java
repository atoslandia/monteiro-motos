package passageiro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


import projeto_poo.Mototaxista;
import projeto_poo.botoes.BotaoAgendar;
import projeto_poo.botoes.BotaoMais;
import projeto_poo.botoes.BotaoMenos;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaCorridaConcluida extends JanelaPadrao {
	
//	private Mototaxista mototaxista;
	private float nota;
	private String aaa;
	
	public JanelaCorridaConcluida(/*mototaxista*/) {
		super("Corrida concluida");
//		this.mototaxista = mototaxista
		add(getFundoPadrao());
		logo();
		avaliar();
		
		
		
		setVisible(true);
	}
	private void logo() {
		TextoImagemPadrao corridaConcluida = new TextoImagemPadrao(new ImageIcon("imgs/passageiro/corridaconcluida.png"));
		corridaConcluida.setBounds(30, 30, 444, 41);
		TextoImagemPadrao txtAvaliar = new TextoImagemPadrao("Avalie a corrida: ");
		txtAvaliar.setBounds(30, 91, 150, 20);
		add(txtAvaliar);
		add(corridaConcluida);
	}

	private void avaliar() {
		BotaoMenos menos = new BotaoMenos();
		menos.setLocation(60, 121);
		menos.addActionListener(new OuvinteBotaoMenos());
		BotaoMais mais = new BotaoMais();
		mais.addActionListener(new OuvinteBotaoMais());
		mais.setLocation(201,121);
		
		TextoImagemPadrao avaliacao = new TextoImagemPadrao(aaa);
		avaliacao.setFont(new Font("Calibrii", Font.BOLD, 40));
		avaliacao.setBounds(121, 115, 60, 50);
		
		add(avaliacao);
		
		add(menos);
		add(mais);
	}
	
	private class OuvinteBotaoMais implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(nota < 5)
				nota += 0.5;	
		}
		
	}
	private class OuvinteBotaoMenos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nota > 0) {
				aaa = Float.toString(nota -= 0.5);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new JanelaCorridaConcluida();
	}
}
