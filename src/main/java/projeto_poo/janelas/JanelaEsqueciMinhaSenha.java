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
import projeto_poo.botoes.BotaoProsseguir;
import projeto_poo.botoes.BotaoVoltar;
import projeto_poo.caixas.CaixaCodigo;
import projeto_poo.caixas.CaixaEmail;
import projeto_poo.caixas.CaixaSenha;
import projeto_poo.caixas.CaixaTextoPadrao;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.erros.UsuarioNaoExisteException;
import projeto_poo.paineis.PainelConfirmarEmail;
import projeto_poo.paineis.PainelPadrao;

public class JanelaEsqueciMinhaSenha extends JanelaPadrao {
	
	private CaixaTextoPadrao email;
	private CaixaSenha senha;

//	private JLabel avisoUsuarioNaoExiste;
	
	private InserirEmailPainel inserirEmailPainel;
	private InserirCodigoPainel inserirCodigoPainel;
	private RedefinirSenhaPainel redefinirSenhaPainel;
	
	private Random c = new Random();
	private String codigoGerado = Integer.toString(c.nextInt(1000,9999));
	
	public JanelaEsqueciMinhaSenha() {
		super("Verificar e-mail");
		add(inserirEmailPainel = new InserirEmailPainel());
		setVisible(true);
	}
	
	private class InserirEmailPainel extends PainelPadrao{
		
		public InserirEmailPainel() {
			super();
			caixaEmail();
			prosseguir();
			voltar();
			logo();
			add(getFundoPadrao());
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/esqueciminhasenha.png"));
			logo.setBounds(30, 30, 503, 37);
			add(logo);
		}
		
		private void caixaEmail() {
			JLabel textoEmail = new TextoImagemPadrao("E-mail: ");
	        textoEmail.setBounds(30, 120, 100, 20);
	        add(textoEmail);
	        
	        email = new CaixaEmail();
	        email.setBounds(120, 120, 200, 20);
	        add(email);
		}
		
		private void prosseguir() {
			BotaoProsseguir prosseguir = new BotaoProsseguir();
			prosseguir.addActionListener(new OuvinteProsseguirEmail());
			add(prosseguir);
		}
		
		private void voltar() {
			BotaoVoltar voltar = new BotaoVoltar();
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					new JanelaLogin();
				}
			});
			add(voltar);
		}
	}
	
	private class InserirCodigoPainel extends PainelConfirmarEmail{
		
		public InserirCodigoPainel() {
			super();
			prosseguir();
			voltar();
			add(getFundoPadrao());
		}
		
		private void prosseguir() {
			BotaoProsseguir prosseguir = new BotaoProsseguir();
			prosseguir.addActionListener(new OuvinteProsseguirCodigo());
			add(prosseguir);
		}
		
		private void voltar() {
			BotaoVoltar voltar = new BotaoVoltar();
			voltar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inserirEmailPainel.setVisible(true);
					inserirCodigoPainel.setVisible(false);
				}
			});
			add(voltar);
		}
		
	}
	
	private class RedefinirSenhaPainel extends PainelPadrao{
		public RedefinirSenhaPainel() {
			super();
			inserirSenha();
			botaoProsseguir();
			logo();
			add(getFundoPadrao());
		}
		
		private void logo() {
			JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/esqueciminhasenha.png"));
			logo.setBounds(30, 30, 503, 37);
			add(logo);
		}
		
		private void inserirSenha() {
			TextoImagemPadrao textoSenha = new TextoImagemPadrao("Senha: ");
			textoSenha.setBounds(30, 120, 200, 20);
			add(textoSenha);
			
			senha = new CaixaSenha();
			senha.setBounds(120, 120, 200, 20);
			add(senha);
			
		}
		private void botaoProsseguir() {
			JButton botaoProsseguir = new BotaoProsseguir();
			botaoProsseguir.addActionListener(new OuvinteRedefinirSenha());
			add(botaoProsseguir);
		}
		
	}
	
	private class OuvinteProsseguirEmail implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				try {
					getPersistencia().buscarCentral().recuperarUsuarioPeloEmail(email.pegarConteudo());
					Mensageiro.enviarCodigoEmail(email.getText(), codigoGerado);
					inserirEmailPainel.setVisible(false);
					add(inserirCodigoPainel = new InserirCodigoPainel());
				} catch (UsuarioNaoExisteException e1) {
					new JanelaDeAvisoPadrao("E-mail incorreto ou inexistente");
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		}
	}
	
	private class OuvinteProsseguirCodigo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
				try {
					inserirCodigoPainel.getCodigo().comparar(codigoGerado);
					inserirCodigoPainel.setVisible(false);
					add(redefinirSenhaPainel = new RedefinirSenhaPainel());
				}catch (CaixaVaziaException e1) {
					e1.printStackTrace();
				}
			}
	}
	
	private class OuvinteRedefinirSenha implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
				try {
					senha.pegarConteudo();
					redefinirSenhaPainel.setVisible(false);
					CentralDeInformacoes persistencia = getPersistencia().buscarCentral();
					Usuario usuario = persistencia.recuperarUsuarioPeloEmail(email.pegarConteudo());
					usuario.setSenha(senha.pegarConteudo());
					getPersistencia().salvarPersistencia(persistencia);
					dispose();
					new JanelaDeAvisoPadrao("Senha alterada com sucesso!", new JanelaLogin());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		}
	}
}
