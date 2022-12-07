package projeto_poo.janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Mensageiro;
import projeto_poo.Usuario;
import projeto_poo.componentes.CaixaEmail;
import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.erros.UsuarioNaoExisteException;

public class JanelaEsqueciMinhaSenha extends JanelaPadrao {

	private CaixaTextoPadrao email;
	private CaixaTextoPadrao codigo;
	private JLabel textoCodigo;
	
	private JButton botaoProsseguir;
	private JButton botaoConfirmarCodigo;
	private JButton botaoConcluir;
	
	private JLabel avisoPreencherEmail;
	private JLabel avisoUsuarioNaoExiste;
	
	private Random c = new Random();
	private String codigoGerado = Integer.toString(c.nextInt(1000,9999));
	
	public JanelaEsqueciMinhaSenha() {
		super("Verificar e-mail");
		
		jlEmail();
		botoes();
		inserirCodigo();
		
		avisos();

		add(getFundoPadrao());
		logo();
		setVisible(true);
		
	}
	
	private void logo() {
		JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/esqueciminhasenha.png"));
		logo.setBounds(30, 30, 503, 37);
		add(logo);
	}
	
	private void jlEmail() {
		JLabel textoEmail = new TextoImagemPadrao("E-mail: ");
        textoEmail.setBounds(30, 120, 100, 20);
        add(textoEmail);
        
        email = new CaixaEmail();
        email.setBounds(120, 120, 200, 20);
        add(email);
	}

	private void botoes() {
		JButton botaoProsseguir = getBotaoProsseguir();
		botaoProsseguir.setBounds(500, 155, 170, 41);
		botaoProsseguir.addActionListener(new OuvinteBotaoProsseguir());
		add(botaoProsseguir);
		
		JButton botaoVoltar = getBotaoVoltar();
		botaoVoltar.setBounds(550, 220, 58, 22);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltar());
		add(botaoVoltar);
		
		botaoConfirmarCodigo = getBotaoProsseguir();
		botaoConfirmarCodigo.setBounds(500, 155, 170, 41);
		botaoConfirmarCodigo.setVisible(false);
		botaoConfirmarCodigo.addActionListener(new OuvinteBotaoConfirmarCodigo());
		add(botaoConfirmarCodigo);
		
		botaoConcluir = getBotaoProsseguir();
		botaoConcluir.setBounds(500, 155, 170, 41);
		botaoConcluir.setVisible(false);
//		botaoConcluir.addActionListener(new OuvinteBotaoConcluir());
		add(botaoConcluir);
	}
	
	private void inserirCodigo() {
		textoCodigo = new TextoImagemPadrao("Insira o código: ");
		textoCodigo.setBounds(30, 170, 100, 20);
		textoCodigo.setVisible(false);
        add(textoCodigo);
        
        codigo = new CaixaTextoPadrao();
        codigo.setBounds(120, 170, 200, 20);
        codigo.setVisible(false);
        add(codigo);
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
					getPersistencia().buscarCentral().recuperarUsuarioPeloEmail(email.getText());
					Mensageiro.enviarCodigoEmail(email.getText(), codigoGerado);
					email.setEditable(false);
					codigo.setVisible(true);
					textoCodigo.setVisible(true);
					
					botaoProsseguir.setVisible(false);
					botaoConfirmarCodigo.setVisible(true);
					
				} catch (UsuarioNaoExisteException e2) {
					avisoUsuarioNaoExiste.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
		} else
			avisoPreencherEmail.setVisible(true);
		}	
	}
	
	
	private class OuvinteBotaoConfirmarCodigo implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(codigo.getText().equals(codigoGerado)) {
//				new JanelaAlterarSenha();
		} else
			codigo.setBorder(getBordaErro());
		}
	}
	private class OuvinteBotaoVoltar implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaLogin();
		}
		
	}
}
