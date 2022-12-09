package projeto_poo.janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import projeto_poo.botoes.BotaoPadrao;
import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.diversos.TextoImagemPadrao;

public class JanelaDeAvisoPadrao extends JanelaPadrao{

	private String aviso;
	
	public JanelaDeAvisoPadrao(String aviso, JanelaPadrao proximaJanela) {
		super("Atenção");
		this.aviso = aviso;
		setSize(300,150);
		textoAviso();
		botaoVoltar();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public JanelaDeAvisoPadrao(String aviso) {
		super("Atenção");
		this.aviso = aviso;
		setSize(300,150);
		textoAviso();
		botaoVoltar();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	private void textoAviso() {
		JLabel texto = new TextoImagemPadrao(aviso);
		texto.setBounds(-5, 5, 300, 50);
		texto.setHorizontalAlignment(JLabel.CENTER);
		add(texto);
	}
	
	private void botaoVoltar() {
		BotaoVoltar botaoVoltar = new BotaoVoltar();
		botaoVoltar.setBounds(115, 75, 58, 22);
		botaoVoltar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(botaoVoltar);
	}
}
