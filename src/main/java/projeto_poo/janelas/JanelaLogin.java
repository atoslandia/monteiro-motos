package projeto_poo.janelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import projeto_poo.diversos.TextoImagemPadrao;
import projeto_poo.erros.AdministradroNaoExisteException;
import projeto_poo.erros.NaoExisteXmlException;

public class JanelaLogin extends JanelaPadrao{
	
	private JTextField email;
    private JPasswordField senha;
    private JComboBox<String> tipoDeConta;
    private JRadioButton passageiro;
    private JRadioButton mototaxista;

    private BotaoPadrao botaoEntrar;
    private BotaoPadrao botaoEsqueciSenha;
    private BotaoPadrao botaoCriarConta;
    private String[] tiposDeConta = {"Passageiro", "Mototaxista", "Administrador"};
    
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
        JLabel fundoLogin = new TextoImagemPadrao(new ImageIcon("imgs/fundo-login.png"));
        fundoLogin.setBounds(15, -7, 768, 406);
        add(fundoLogin);
    }

    private void logoLogin() {
        JLabel logo = new TextoImagemPadrao(new ImageIcon("imgs/logo.png"));
        logo.setBounds(30, 30, 470, 31);
        add(logo);
    }

    private void textoEmail() {
        JLabel textoEmail = new TextoImagemPadrao("E-mail: ");
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
        
        tipoDeConta = new JComboBox<String>(tiposDeConta);
        tipoDeConta.setFont(new Font("Calibrii", Font.PLAIN, 10));
        tipoDeConta.setBounds(120, 220, 200, 20);
        add(tipoDeConta);
        

//        passageiro = new OpcaoRadioPadrao("Passageiro");
//        passageiro.setBounds(120, 250, 100, 20);
//        add(passageiro);
//
//        mototaxista = new OpcaoRadioPadrao("Mototaxista");
//        mototaxista.setBounds(220, 250, 100, 20);
//        add(mototaxista);
//
//        ButtonGroup grupo = new ButtonGroup();
//        grupo.getSelection();
//        grupo.add(passageiro);
//        grupo.add(mototaxista);
    }
// botoes

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
			if(email.getText().equals(""))
				email.setBorder(getBordaErro());
			else email.setBorder(getBorda());
			if(new String(senha.getPassword()).length() < 4 || new String(senha.getPassword()).equals(""))
				senha.setBorder(getBordaErro());
			else senha.setBorder(getBorda());
			
			try {
				Usuario usuario = dados.recuperarUsuarioPeloEmail(email.getText());
				if(tipoDeConta.getSelectedItem().equals(tiposDeConta[0]) && usuario instanceof Passageiro) {
					if(usuario.getSenha().equals(new String(senha.getPassword())))
						System.out.println("passageiro");
					}
				else if(tipoDeConta.getSelectedItem().equals(tiposDeConta[1]) && usuario instanceof Mototaxista) {
					if(usuario.getSenha().equals(new String(senha.getPassword())))
						System.out.println("mototaxista");
					
				} else if(tipoDeConta.getSelectedItem().equals(tiposDeConta[2]) && usuario instanceof Administrador){
					if(usuario.getSenha().equals(new String(senha.getPassword())))
						System.out.println("adm");
					
				}
					
				} catch (Exception e1) {
					email.setBorder(getBordaErro());
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
