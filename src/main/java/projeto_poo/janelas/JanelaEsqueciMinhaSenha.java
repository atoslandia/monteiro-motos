package projeto_poo.janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Mensageiro;
import projeto_poo.Usuario;
import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.erros.UsuarioNaoExisteException;

public class JanelaEsqueciMinhaSenha extends JanelaPadrao {

	private CaixaTextoPadrao email;
	
	public JanelaEsqueciMinhaSenha() {
		super("Esqueci minha senha");
		
		jlEmail();
		botoes();
		
		avisos();

		add(getFundoPadrao());
		logo();
		setVisible(true);
		
	}
	
	private JLabel avisoPreencherEmail;
	private JLabel avisoUsuarioNaoExiste;
	
	private void logo() {
		JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/esqueciminhasenha.png"));
		logo.setBounds(30, 30, 503, 37);
		add(logo);
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
		botaoProsseguir.addActionListener(new OuvinteBotaoProsseguir());
		add(botaoProsseguir);
		
		JButton botaoVoltar = getBotaoVoltar();
		botaoVoltar.setBounds(550, 220, 58, 22);
		
		botaoVoltar.addActionListener(new OuvinteBotaoVoltar());
		
		add(botaoVoltar);
	}
	
	private void avisos() {
    	avisoPreencherEmail = new TextoImagemPadrao("Preencha com seu e-mail!");
    	avisoPreencherEmail.setForeground(Color.RED);
    	avisoPreencherEmail.setVisible(false);
    	avisoPreencherEmail.setBounds(120, 100, 150, 20);
    	add(avisoPreencherEmail);
    	
    	avisoUsuarioNaoExiste = new TextoImagemPadrao("O usuário não existe!");
    	avisoUsuarioNaoExiste.setForeground(Color.RED);
    	avisoUsuarioNaoExiste.setVisible(false);
    	avisoUsuarioNaoExiste.setBounds(120, 100, 150, 20);
    	add(avisoUsuarioNaoExiste);
	}
	
	private class OuvinteBotaoProsseguir implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			avisoPreencherEmail.setVisible(false);
			avisoUsuarioNaoExiste.setVisible(false);
			
			if(!email.getText().equals("")) {
				try {
					Random c = new Random();
					String codigo = Integer.toString(c.nextInt(1000,9999));
					Usuario usuario = getPersistencia().buscarCentral().recuperarUsuarioPeloEmail(email.getText());
					Mensageiro.enviarCodigoEmail(email.getText(), codigo);
					
					new JanelaConfirmarEmail(codigo, usuario);
					dispose();
					
				} catch (UsuarioNaoExisteException e2) {
					avisoUsuarioNaoExiste.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		} else
			avisoPreencherEmail.setVisible(true);
		}	
	}
	
	private class OuvinteBotaoVoltar implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaLogin();
		}
		
	}
	
	
}
