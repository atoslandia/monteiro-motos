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
import projeto_poo.componentes.PainelEsqueciSenha;
import projeto_poo.componentes.PainelPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.erros.NaoExisteXmlException;
import projeto_poo.erros.UsuarioNaoExisteException;

public class JanelaEsqueciMinhaSenha extends JanelaPadrao {
	
	private boolean painelEmailAberto = true;
	private boolean painelCodigoAberto = false;
	private boolean painelRedefinirSenhaAberto = false;
	
	private CaixaTextoPadrao email;
	private CaixaTextoPadrao codigo;
	private CaixaSenha senha;

//	private JButton botaoProsseguir;
//	private JButton botaoVoltar;
	
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
	
	
	private class InserirEmailPainel extends PainelEsqueciSenha{
		
		public InserirEmailPainel() {
			super(new OuvinteBotaoProsseguir(), new OuvinteBotaoVoltarEmail());
			caixaEmail();
		}
		
		private void caixaEmail() {
			JLabel textoEmail = new TextoImagemPadrao("E-mail: ");
	        textoEmail.setBounds(30, 120, 100, 20);
	        add(textoEmail);
	        
	        email = new CaixaEmail();
	        email.setBounds(120, 120, 200, 20);
	        add(email);
		}
		
	}
	
	private class InserirCodigoPainel extends PainelEsqueciSenha{
		
		public InserirCodigoPainel() {
			super(new OuvinteBotaoProsseguir(), new OuvinteBotaoVoltarEmail());
			txtInserirCodigo();
			inserirCodigo();
		}
		
		private void txtInserirCodigo() {
			TextoImagemPadrao texto = new TextoImagemPadrao("Verifique seu e-mail e preencha com o código enviado:");
			texto.setBounds(30, 90, 350, 20);
			add(texto);
		}
		
		private void inserirCodigo() {
			TextoImagemPadrao textoCodigo = new TextoImagemPadrao("Insira o código: ");
			textoCodigo.setBounds(30, 130, 100, 20);
	        add(textoCodigo);
	        
	        codigo = new CaixaTextoPadrao();
	        codigo.setBounds(150, 130, 200, 20);
	        add(codigo);
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
			JButton botaoProsseguir = new BotaoProsseguir();
			botaoProsseguir.setBounds(500, 155, 170, 41);
			botaoProsseguir.addActionListener(new OuvinteBotaoProsseguir());
			add(botaoProsseguir);
		}
		
	}
	
	private class OuvinteBotaoProsseguir implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(painelEmailAberto) {
				try {
					getPersistencia().buscarCentral().recuperarUsuarioPeloEmail(email.getText());
					Mensageiro.enviarCodigoEmail(email.getText(), codigoGerado);
					inserirEmailPainel.setVisible(false);
					painelEmailAberto = false;
					add(inserirCodigoPainel = new InserirCodigoPainel());
					painelCodigoAberto = true;
					
				} catch (UsuarioNaoExisteException e1) {
					e1.printStackTrace();
				} catch (NaoExisteXmlException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(painelCodigoAberto) {
				if(codigo.getText().equals(codigoGerado)) {
					inserirCodigoPainel.setVisible(false);
					painelCodigoAberto = false;
					add(redefinirSenhaPainel = new RedefinirSenhaPainel());
				} else
					codigo.setBorder(getBordaErro());
			}else
				try {
					CentralDeInformacoes persistencia = getPersistencia().buscarCentral();
					Usuario usuario = persistencia.recuperarUsuarioPeloEmail(email.getText());
					usuario.setSenha(new String(senha.getPassword()));
					getPersistencia().salvarPersistencia(persistencia);
					dispose();
					new JanelaLogin();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}

	private class OuvinteBotaoVoltarEmail implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(painelEmailAberto) {
				dispose();
				new JanelaLogin();
			}else
				inserirCodigoPainel.setVisible(false);
			painelCodigoAberto = false;
			inserirEmailPainel.setVisible(true);
			painelEmailAberto = true;
		}
		
	}
	
	
}
