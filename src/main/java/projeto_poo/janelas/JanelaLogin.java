package projeto_poo.janelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Usuario;
import projeto_poo.botoes.BotaoPadrao;
import projeto_poo.caixas.CaixaEmail;
import projeto_poo.caixas.CaixaSenha;
import projeto_poo.diversos.ComboUsuarios;
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.AdministradroNaoExisteException;
import projeto_poo.erros.CaixaVaziaException;
import projeto_poo.erros.NaoExisteXmlException;
import projeto_poo.erros.UsuarioNaoExisteException;

public class JanelaLogin extends JanelaPadrao{
	
	private CaixaEmail email;
    private CaixaSenha senha;
    private ComboUsuarios tipoDeConta;

    private BotaoPadrao botaoEntrar;
    private BotaoPadrao botaoEsqueciSenha;
    private BotaoPadrao botaoCriarConta;
    
    private CentralDeInformacoes dados;
	
    public JanelaLogin() {
        super("Login");
        
        
        logoLogin();
        textoEmail();
        textoSenha();
        tipoDeConta();

        botaoEntrar();
        botaoEsqueciSenha();
        botaoCriarConta();

        fundoLogin();
        
        setVisible(true);
        
        verificarPersistencia();

    }
	
    private void verificarPersistencia() {
    	try {
    		dados = getPersistencia().buscarCentral();
    		dados.verificarAdm();
		} catch (NaoExisteXmlException | AdministradroNaoExisteException e) {
			dispose();
			new JanelaPrimeiroAcesso();
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
    private void fundoLogin() {
    	TextoImagemPadrao fundoLogin = new TextoImagemPadrao(new ImageIcon("imgs/fundo-login.png"));
        fundoLogin.setBounds(15, -7, 768, 406);
        add(fundoLogin);
    }

    private void logoLogin() {
    	TextoImagemPadrao logo = new TextoImagemPadrao(new ImageIcon("imgs/logo.png"));
        logo.setBounds(30, 30, 470, 31);
        add(logo);
    }

    private void textoEmail() {
    	TextoImagemPadrao textoEmail = new TextoImagemPadrao("E-mail: ");
        textoEmail.setBounds(30, 120, 100, 20);
        add(textoEmail);

        email = new CaixaEmail();
        email.setBounds(120, 120, 200, 20);
        add(email);

    }
    private void textoSenha() {
        JLabel textoSenha = new TextoImagemPadrao("Senha: ");
        textoSenha.setBounds(30,170,100,20);
        add(textoSenha);

        senha = new CaixaSenha();
        senha.setBounds(120, 170, 200, 20);
        add(senha);
    }

    private void tipoDeConta() {
        JLabel textoTipoDeConta = new TextoImagemPadrao("Tipo de Conta: ");
        textoTipoDeConta.setBounds(30, 220, 100, 20);
        add(textoTipoDeConta);
        
        tipoDeConta = new ComboUsuarios();
        add(tipoDeConta);
        
    }

    private void botaoEntrar() {
    	botaoEntrar = new BotaoPadrao();
    	botaoEntrar.setIcon(new ImageIcon("imgs/botao-entrar.png"));
    	botaoEntrar.setPressedIcon(new ImageIcon("imgs/botao-entrar.png","imgs/botao-entrarclicado.png"));
        botaoEntrar.setBounds(530, 155, 170, 41);
        botaoEntrar.addActionListener(new OuvinteEntrar());
        add(botaoEntrar);
    }

    private void botaoEsqueciSenha() {
    	botaoEsqueciSenha = new BotaoPadrao();
    	botaoEsqueciSenha.setIcon(new ImageIcon("imgs/botao-esqueciasenha.png"));
    	botaoEsqueciSenha.setPressedIcon(new ImageIcon("imgs/botao-esqueciasenhaclicado.png"));
		botaoEsqueciSenha.setBounds(530, 215, 170, 26);
		botaoEsqueciSenha.addActionListener(new OuvinteEsqueciSenha());
        add(botaoEsqueciSenha);
    }

    private void botaoCriarConta() {
    	botaoCriarConta = new BotaoPadrao();
		botaoCriarConta.setIcon(new ImageIcon("imgs/botao-criarconta.png"));
		botaoCriarConta.setPressedIcon(new ImageIcon("imgs/botao-criarcontaclicado.png"));
		botaoCriarConta.setBounds(530, 250, 170, 26);
		botaoCriarConta.addActionListener(new OuvinteCriarConta());
        add(botaoCriarConta);
    }

	private class OuvinteEntrar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			try {
				email.pegarConteudo();
				senha.pegarConteudo();
				Usuario usuario = dados.recuperarUsuarioPeloEmail(email.pegarConteudo());
				senha.compararSenha(usuario);
				tipoDeConta.tipoSelecionado(usuario);
				dispose();
//				if(tipoDeConta.passageiro(usuario)) {
//						System.out.println("passageiro");
//					}
//				else if(tipoDeConta.mototaxista(usuario)) {
//						System.out.println("mototaxista");
//					
//				} else if(tipoDeConta.administrador(usuario)){
//						new JanelaInicioAdministrador(usuario);
//				}
				} catch (CaixaVaziaException e1) {
					getAvisoPreencherDados().setBounds(120, 100, 150, 20);
					getAvisoPreencherDados().setVisible(true);
					e1.printStackTrace();
				} catch (UsuarioNaoExisteException e1) {
					new JanelaDeAvisoPadrao("Dados incorretos ou não existem!");
					e1.printStackTrace();
				}
			}
	}
	
	
	private class OuvinteEsqueciSenha implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaEsqueciMinhaSenha();
		}
		
	}
	
	private class OuvinteCriarConta implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaCriarConta();
		}
	}

}
