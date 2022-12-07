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
import projeto_poo.componentes.BotaoPadrao;
import projeto_poo.componentes.BotaoProsseguir;
import projeto_poo.componentes.BotaoVoltar;
import projeto_poo.componentes.CaixaEmail;
import projeto_poo.componentes.CaixaSenha;
import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.ComponentesEstaticos;
import projeto_poo.componentes.PainelPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.erros.NaoExisteXmlException;
import projeto_poo.erros.UsuarioNaoExisteException;

public class JanelaEsqueciMinhaSenha extends JanelaPadrao {

	private CaixaTextoPadrao email;
	private CaixaTextoPadrao codigo;
	private CaixaSenha senha;

	private JButton botaoConcluir;
	
	private JLabel avisoPreencherEmail;
	private JLabel avisoUsuarioNaoExiste;
	
	private InserirEmailPainel inserirEmailPainel;
	private InserirCodigoPainel inserirCodigoPainel;
	private RedefinirSenhaPainel redefinirSenhaPainel;
	
	private Random c = new Random();
	private String codigoGerado = Integer.toString(c.nextInt(1000,9999));
	
	
	public JanelaEsqueciMinhaSenha() {
		super("Verificar e-mail");
		
		
		logo();
		
		
		add(inserirEmailPainel = new InserirEmailPainel());
		
		setVisible(true);
	}
	
	private void logo() {
		JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/esqueciminhasenha.png"));
		logo.setBounds(30, 30, 503, 37);
		add(logo);
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
	

	private class InserirEmailPainel extends PainelPadrao{
		
		public InserirEmailPainel() {
			super();
			caixaEmail();
			botaoProsseguir();
			botaoVoltar();
			add(ComponentesEstaticos.fundoPadrao());
		}
		
		private void caixaEmail() {
			JLabel textoEmail = new TextoImagemPadrao("E-mail: ");
	        textoEmail.setBounds(30, 120, 100, 20);
	        add(textoEmail);
	        
	        email = new CaixaEmail();
	        email.setBounds(120, 120, 200, 20);
	        add(email);
		}
		
		private void botaoProsseguir() {
			BotaoProsseguir botaoConcluir = new BotaoProsseguir();
			botaoConcluir.setBounds(500, 155, 170, 41);
			botaoConcluir.addActionListener(new OuvinteBotaoInserirEmail());
			add(botaoConcluir);
		}
		
		private void botaoVoltar() {
			JButton botaoVoltar = new BotaoVoltar();
			botaoVoltar.setBounds(550, 220, 58, 22);
			add(botaoVoltar);
		}
		
	}
	
	private class InserirCodigoPainel extends PainelPadrao{
		
		public InserirCodigoPainel() {
			super();
			inserirCodigo();
			botaoProsseguir();
			botaoVoltar();
			add(ComponentesEstaticos.fundoPadrao());
		}
		
		private void inserirCodigo() {
			TextoImagemPadrao textoCodigo = new TextoImagemPadrao("Insira o código: ");
			textoCodigo.setBounds(30, 170, 100, 20);
	        add(textoCodigo);
	        
	        codigo = new CaixaTextoPadrao();
	        codigo.setBounds(120, 170, 200, 20);
	        add(codigo);
		}

		private void botaoVoltar() {
			JButton botaoVoltar = new BotaoVoltar();
			botaoVoltar.setBounds(550, 220, 58, 22);
			add(botaoVoltar);
		}
		
		private void botaoProsseguir() {
			BotaoProsseguir botaoProsseguir = new BotaoProsseguir();
			botaoProsseguir.setBounds(500, 155, 170, 41);
			botaoProsseguir.addActionListener(new OuvinteBotaoInserirCodigo());
			add(botaoProsseguir);
		}
		
	}
	
	private class RedefinirSenhaPainel extends PainelPadrao{
		public RedefinirSenhaPainel() {
			super();
			inserirSenha();
			botaoProsseguir();
			add(ComponentesEstaticos.fundoPadrao());
		}
		
		private void inserirSenha() {
			TextoImagemPadrao textoSenha = new TextoImagemPadrao("Senha: ");
			textoSenha.setBounds(30, 170, 100, 20);
			add(textoSenha);
			
			senha = new CaixaSenha();
			senha.setBounds(120, 170, 200, 20);
			add(senha);
			
		}
		
		private void botaoProsseguir() {
			botaoConcluir = new BotaoProsseguir();
			botaoConcluir.setBounds(500, 155, 170, 41);
			botaoConcluir.addActionListener(new OuvinteBotaoRedefinirSenha());
			add(botaoConcluir);
		}
		
	}
	
	private class OuvinteBotaoInserirEmail implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				getPersistencia().buscarCentral().recuperarUsuarioPeloEmail(email.getText());
				Mensageiro.enviarCodigoEmail(email.getText(), codigoGerado);
				inserirEmailPainel.setVisible(false);
				add(inserirCodigoPainel = new InserirCodigoPainel());
				
			} catch (UsuarioNaoExisteException e1) {
				e1.printStackTrace();
			} catch (NaoExisteXmlException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	private class OuvinteBotaoInserirCodigo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(codigo.getText().equals(codigoGerado)) {
				inserirCodigoPainel.setVisible(false);
				add(redefinirSenhaPainel = new RedefinirSenhaPainel());
			} else
				codigo.setBorder(getBordaErro());
		}
	}
	
	private class OuvinteBotaoRedefinirSenha implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				CentralDeInformacoes persistencia = getPersistencia().buscarCentral();
				Usuario usuario = persistencia.recuperarUsuarioPeloEmail(email.getText());
				usuario.setSenha(new String(senha.getPassword()));
				getPersistencia().salvarPersistencia(persistencia);
				System.out.println("deu tudo certo!");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
	
}
