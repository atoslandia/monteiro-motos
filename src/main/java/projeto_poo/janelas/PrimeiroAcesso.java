package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import projeto_poo.ouvintes.OuvinteComponentesPreenchidosDeDados;
import projeto_poo.ouvintes.OuvinteTeclasBloqueadas;
import projeto_poo.ouvintes.OuvinteTeclasEspeciais;

public class PrimeiroAcesso extends JanelaPadrao{
	
	public PrimeiroAcesso() {
		super("Primeiro acesso");
		botaoProsseguir();
		
		caixaNome();
		caixaSobrenome();
		caixaEmail();
		caixaSenha();
		escolhaSexo();
		
		add(getFundoPadrao());
		
		logoPrimeiroAcesso();
		
		setVisible(true);
	}
	
	private JLabel textoNome;
	private JTextField nome;
	private JLabel textoSobrenome;
	private JTextField sobrenome;
	private JLabel textoEmail;
	private JTextField email;
	private JLabel textoSenha;
	private JPasswordField senha;
	private JLabel textoSexo;
	private JRadioButton feminino;
	private JRadioButton masculino;
	
	private void logoPrimeiroAcesso() {
		JLabel logo = new JLabel(new ImageIcon("imgs/primeiroacesso.png"));
		logo.setBounds(30, 30, 394, 32);
		add(logo);
	}
	
//	botoes
	private void botaoProsseguir() {
		JButton botaoProsseguir = getBotaoProsseguir();
		botaoProsseguir.setBounds(530, 185, 170, 41);
		OuvinteComponentesPreenchidosDeDados componentesPreenchidos = new OuvinteComponentesPreenchidosDeDados(this);
		botaoProsseguir.addActionListener(componentesPreenchidos);
			
		add(botaoProsseguir);
	}
	
//	componentes
	private void caixaNome(){
		textoNome = new TextoImagemPadrao("Nome:");
		textoNome.setBounds(30, 85, 100, 19);
		add(textoNome);
		
		nome = new CaixaTextoPadrao();
		nome.addKeyListener(getTeclasBloqueadas());
		nome.setToolTipText(getTeclasBloqueadas().getTeclasEspeciais());
		nome.setBounds(140, 85, 200, 20);
		add(nome);
	}
	
	private void caixaSobrenome(){
		textoSobrenome = new TextoImagemPadrao("Sobrenome:");
		textoSobrenome.setBounds(30, 125, 100, 19);
		add(textoSobrenome);
		
		sobrenome = new CaixaTextoPadrao();
		sobrenome.addKeyListener(getTeclasBloqueadas());
		sobrenome.setToolTipText(getTeclasBloqueadas().getTeclasEspeciais());
		sobrenome.setBounds(140, 125, 200, 20);
		add(sobrenome);
	}
	
	private void caixaEmail() {
		textoEmail = new JLabel("Email:");
		textoEmail.setBounds(30, 165, 100, 19);
		add(textoEmail);
		
		email = new CaixaTextoPadrao();
		email.addKeyListener(getTeclasEspeciais());
		email.setToolTipText(getTeclasEspeciais().getTeclasEspeciais());
		email.setBounds(140, 165, 200, 20);
		add(email);
	}
	
	private void caixaSenha(){
		textoSenha = new TextoImagemPadrao("Senha:");
		textoSenha.setBounds(30, 205, 100, 19);
		add(textoSenha);
		
		senha = new CaixaPadraoSenha();
		senha.addKeyListener(getTeclasEspeciais());
		senha.setToolTipText(getTeclasEspeciais().getTeclasEspeciais());
		senha.setBounds(140, 205, 200, 20);
		add(senha);
	}
	
	private void escolhaSexo() {
		textoSexo = new TextoImagemPadrao("Sexo:");
		textoSexo.setBounds(30, 245, 100, 19);
		add(textoSexo);
		
		feminino = new OpcaoRadioPadrao("Feminino");
		feminino.setBounds(140, 245, 100, 20);
		add(feminino);
		
		masculino = new OpcaoRadioPadrao("Masculino");
		masculino.setBounds(250, 245, 100, 20);
		add(masculino);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.getSelection();
		grupo.add(feminino);
		grupo.add(masculino);
	}
	
	public JLabel getTextoNome() {
		return textoNome;
	}
	
	public JTextField getNome() {
		return nome;
	}
	
	public JLabel getTextoSobrenome() {
		return textoSobrenome;
	}
	
	public JTextField getSobrenome() {
		return sobrenome;
	}
	
	public JLabel getTextoEmail() {
		return textoEmail;
	}
	
	public JTextField getEmail() {
		return email;
	}
	
	public JLabel getTextoSenha() {
		return textoSenha;
	}
	
	public JPasswordField getSenha() {
		return senha;
	}
	
	public JRadioButton getFeminino() {
		return feminino;
	}
	
	public JRadioButton getMasculino() {
		return masculino;
	}
}
