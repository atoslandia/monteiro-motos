package mototaxista;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.GeradorDeRelatorios;
import projeto_poo.Mototaxista;
import projeto_poo.botoes.BotaoConcluir;
import projeto_poo.botoes.BotaoMais;
import projeto_poo.botoes.BotaoMenos;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.janelas.JanelaPadrao;

public class JanelaComprarCreditosDeReinvidicacao extends JanelaPadrao{
	
	private int quantidade;
	private float valorTotal;
	
	private TextoImagemPadrao textoQuantidade;
	private TextoImagemPadrao textoValorTotal;
	
	private Mototaxista mototaxista;
	
	public JanelaComprarCreditosDeReinvidicacao(Mototaxista mototaxista) {
		super("Comprar créditos de reinvidicação");
		this.mototaxista = mototaxista;
		textos();
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
		
		try {
			TextoImagemPadrao valorDoCredito = new TextoImagemPadrao("Valor dos créditos de reinvidicação: "+getPersistencia().buscarCentral().getValorCreditoReinvidicacao()+" R$");
			valorDoCredito.setBounds(30, 67, 350, 20);
			add(valorDoCredito);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		textoQuantidade = new TextoImagemPadrao(Integer.toString(quantidade));
		textoQuantidade.setBounds(95, 165, 50, 50);
		textoQuantidade.setFont(new Font("Calibrii", Font.BOLD, 40));
		add(textoQuantidade);
		
		textoValorTotal = new TextoImagemPadrao(valorTotal+" R$");
		textoValorTotal.setBounds(240, 165, 300, 50);
		textoValorTotal.setFont(new Font("Calibrii", Font.BOLD, 40));
		add(textoValorTotal);
		
	}
	
	private void botoes() {
		
		BotaoMais mais = new BotaoMais();
		mais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textoQuantidade.setText(Integer.toString(++quantidade));
					valorTotal = getPersistencia().buscarCentral().getValorCreditoReinvidicacao()*quantidade;
					textoValorTotal.setText(valorTotal+" R$");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		add(mais);
		
		BotaoMenos menos = new BotaoMenos();
		menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(quantidade > 0) {
						textoQuantidade.setText(Integer.toString(--quantidade));
						valorTotal = getPersistencia().buscarCentral().getValorCreditoReinvidicacao()*quantidade;
						textoValorTotal.setText(valorTotal+" R$");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		add(menos);

		BotaoConcluir concluir = new BotaoConcluir();
		concluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(valorTotal != 0) {
					try {
						GeradorDeRelatorios.gerarBoleto(mototaxista, valorTotal);
						File arquivo = new File("boleto.pdf");
						Desktop.getDesktop().open(arquivo);
						mototaxista.setCreditos(mototaxista.getCreditos() + quantidade);
						CentralDeInformacoes cdi = getPersistencia().buscarCentral();
						cdi.atualizarUsuario(mototaxista);
						
						dispose();
						new JanelaPrincipalMototaxista(mototaxista);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		add(concluir);
		
		
		BotaoVoltar voltar = new BotaoVoltar();
		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new JanelaPrincipalMototaxista(mototaxista);
			}
		});
		add(voltar);
	}
	
	
	
}
