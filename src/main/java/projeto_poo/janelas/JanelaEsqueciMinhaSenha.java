package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.TextoImagemPadrao;

public class JanelaEsqueciMinhaSenha extends JanelaPadrao {

	private CaixaTextoPadrao email;
	
	public JanelaEsqueciMinhaSenha() {
		super("Esqueci minha senha");
		
		jlEmail();
		botoes();

		add(getFundoPadrao());
		setVisible(true);
		
	}
	

	
	private void logo() {
		JLabel texto = new TextoImagemPadrao("imgs/");
		
		
	}
	
	/*Criar a classe Botao Email HOJE 06/12/2022*/
	private void jlEmail() {
		JLabel textoEmail = new TextoImagemPadrao("E-mail: ");
        textoEmail.setBounds(30, 120, 100, 20);
        add(textoEmail);
        
        email = new CaixaTextoPadrao();
        email.setBounds(120, 120, 200, 20);
        add(email);
	}
	
	
	private void botoes() {
		JButton botaoProsseguir = getBotaoProsseguir();
				/*largura , autura*/
		botaoProsseguir.setBounds(500, 155, 170, 41);
		
		JButton botaoVoltar = getBotaoVoltar();
		botaoVoltar.setBounds(550, 220, 58, 22);
		
		botaoVoltar.addActionListener(new OuvinteBotaoVoltar());
		
		add(botaoProsseguir);
		add(botaoVoltar);
	}
	
	
	
	private class OuviteBotaoProsseguir implements ActionListener{

		public void actionPerformed(ActionEvent e) {
		
		}
		
	}
	
	private class OuvinteBotaoVoltar implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaLogin();
		}
		
	}
	
	
}
