package passageiro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Corrida;
import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoAgendar;
import projeto_poo.botoes.BotaoBloquear;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoEspecial;
import projeto_poo.botoes.BotaoMais;
import projeto_poo.botoes.BotaoMenos;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaCorridaConcluida extends JanelaPadrao {
	
	private int nota = 5;
	private TextoImagemPadrao avaliacao;
	private BotaoBloquear bloquear;
	
	private Corrida corrida;
	
	public JanelaCorridaConcluida(Corrida corrida) {
		super("Corrida concluida");
		this.corrida = corrida;
		add(getFundoPadrao());
		logo();
		avaliar();
		setVisible(true);
	}
	private void logo() {
		TextoImagemPadrao corridaConcluida = new TextoImagemPadrao(new ImageIcon("imgs/passageiro/corridaconcluida.png"));
		corridaConcluida.setBounds(30, 30, 444, 41);
		add(corridaConcluida);
	}

	private void avaliar() {
		TextoImagemPadrao txtAvaliar = new TextoImagemPadrao("Avalie a corrida: ");
		txtAvaliar.setBounds(30, 120, 150, 20);
		add(txtAvaliar);
		
		BotaoMenos menos = new BotaoMenos();
		menos.addActionListener(new OuvinteBotaoMenos());
		add(menos);

		BotaoMais mais = new BotaoMais();
		mais.addActionListener(new OuvinteBotaoMais());
		add(mais);
		
		avaliacao = new TextoImagemPadrao(Integer.toString(nota));
		avaliacao.setFont(new Font("Calibrii", Font.BOLD, 40));
		avaliacao.setBounds(105, 165, 60, 50);
		add(avaliacao);
		
		bloquear = new BotaoBloquear();
		bloquear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bloquear.setEnabled(false);
		add(bloquear);
		
		BotaoConcluir concluir = new BotaoConcluir();
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					CentralDeInformacoes cdi = getPersistencia().buscarCentral();
					corrida.setCorridaAceita(false);
					cdi.atualizarCorrida(corrida);
					getPersistencia().salvarPersistencia(cdi);
					dispose();
					new JanelaPrincipalPassageiro((Passageiro)corrida.getPassageiro());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		add(concluir);
		
	}
	
	private class OuvinteBotaoMais implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(nota < 5)
				avaliacao.setText(Integer.toString(++nota));
			bloquear.setEnabled(nota < 3);
		}
		
	}
	private class OuvinteBotaoMenos implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nota > 0) {
				avaliacao.setText(Integer.toString(--nota));
			}
			bloquear.setEnabled(nota < 3);
		}
		
	}
}
