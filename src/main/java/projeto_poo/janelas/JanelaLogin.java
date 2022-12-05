package projeto_poo.janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import projeto_poo.Administrador;
import projeto_poo.CentralDeInformacoes;
import projeto_poo.Persistencia;
import projeto_poo.componentes.BotaoPadrao;
import projeto_poo.componentes.CaixaPadraoSenha;
import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.OpcaoRadioPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.ouvintes.OuvinteTeclasEspeciais;

public class JanelaLogin extends JanelaPadrao{
	

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

    private JTextField email;
    private JPasswordField senha;
    private JComboBox<String> tipoDeConta;
    private JRadioButton passageiro;
    private JRadioButton mototaxista;

    private OuvinteTeclasEspeciais teclasEspeciais = new OuvinteTeclasEspeciais();
    private JButton botaoEntrar;
    private JButton botaoEsqueciSenha;
    private JButton botaoCriarConta;
    private String[] tiposDeConta = {"Passageiro", "Mototaxista", "Administrador"};
    
	
    private void verificarPersistencia() {
    	try {
    		CentralDeInformacoes xml = getPersistencia().buscarCentral();
    		System.out.println(xml);
		} catch (Exception e) {
			dispose();
			new PrimeiroAcesso();
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
        textoEmail.setBounds(30, 150, 100, 20);
        add(textoEmail);

        email = new CaixaTextoPadrao();
        email.addKeyListener(teclasEspeciais);
        email.setToolTipText(teclasEspeciais.getTeclasEspeciais());
        email.setBounds(120, 150, 200, 20);
        add(email);

    }
    private void textoSenha() {
        JLabel textoSenha = new TextoImagemPadrao("Senha: ");
        textoSenha.setBounds(30,200,100,20);
        add(textoSenha);

        senha = new CaixaPadraoSenha();
        senha.addKeyListener(teclasEspeciais);
        senha.setToolTipText(teclasEspeciais.getTeclasEspeciais());
        senha.setBounds(120, 200, 200, 20);
        add(senha);
    }

    private void tipoDeConta() {
        JLabel textoTipoDeConta = new TextoImagemPadrao("Tipo de Conta: ");
        textoTipoDeConta.setBounds(30 ,250 ,100 ,20);
        add(textoTipoDeConta);
        
        tipoDeConta = new JComboBox<String>(tiposDeConta);
        
        tipoDeConta.setBounds(120, 250, 200, 20);
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
    	botaoEntrar = new BotaoPadrao("Clique para entrar","imgs/botao-entrar.png","imgs/botao-entrarclicado.png");
        botaoEntrar.setBounds(530, 155, 170, 41);
        botaoEntrar.addActionListener(new OuvinteEntrar());
        add(botaoEntrar);
    }

    private void botaoEsqueciSenha() {
    	botaoEsqueciSenha = new BotaoPadrao("Clique para redefinir a senha", "imgs/botao-esqueciasenha.png","imgs/botao-esqueciasenhaclicado.png");
		botaoEsqueciSenha.setBounds(530, 215, 170, 26);
        add(botaoEsqueciSenha);
    }

    private void botaoCriarConta() {
		botaoCriarConta = new BotaoPadrao("Clique para redefinir a senha","imgs/botao-criarconta.png","imgs/botao-criarcontaclicado.png");
		botaoCriarConta.setBounds(530, 250, 170, 26);
		botaoCriarConta.addActionListener(new OuvinteCriarConta());
        add(botaoCriarConta);
    }

    public JTextField getEmail() {
        return email;
    }


    public JRadioButton getPassageiro() {
        return passageiro;
    }


    public JRadioButton getMototaxista() {
        return mototaxista;
    }

    public JPasswordField getSenha() {
        return senha;
    }

	public JComboBox<String> getTipoDeConta() {
		return tipoDeConta;
	}
	
	private class OuvinteEntrar implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			System.out.println(getTipoDeConta().getSelectedItem());
			
			if(getEmail().getText().equals(""))
				getEmail().setBorder(getBordaErro());
			else getEmail().setBorder(getBorda());
			if(new String(getSenha().getPassword()).length() < 4 || new String(getSenha().getPassword()).equals("")) 
				getSenha().setBorder(getBordaErro());
			else getSenha().setBorder(getBorda());
			
		}
		
	}
	
	private class OuvinteCriarConta implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			dispose();
			new JanelaCriarConta();
			
		}
		
	}

}
