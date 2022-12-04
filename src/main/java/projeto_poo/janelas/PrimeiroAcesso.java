package projeto_poo.janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import projeto_poo.Administrador;
import projeto_poo.Mensageiro;
import projeto_poo.Sexo;
import projeto_poo.componentes.CaixaPadraoSenha;
import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.OpcaoRadioPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
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
	
	private PrimeiroAcesso primeiroAcesso;
	
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
		
		botaoProsseguir.addActionListener(new OuvinteComponentesPreenchidosDeDados());
			
		add(botaoProsseguir);
	}
	
//	componentes
	private void caixaNome(){
		textoNome = new TextoImagemPadrao("Nome:");
		textoNome.setBounds(30, 85, 100, 19);
		add(textoNome);
		
		nome = new CaixaTextoPadrao();
		nome.addKeyListener(new OuvinteTeclasBloqueadas());
		nome.setToolTipText(new OuvinteTeclasBloqueadas().getTeclasEspeciais());
		nome.setBounds(140, 85, 200, 20);
		add(nome);
	}
	
	private void caixaSobrenome(){
		textoSobrenome = new TextoImagemPadrao("Sobrenome:");
		textoSobrenome.setBounds(30, 125, 100, 19);
		add(textoSobrenome);
		
		sobrenome = new CaixaTextoPadrao();
		sobrenome.addKeyListener(new OuvinteTeclasBloqueadas());
		sobrenome.setToolTipText(new OuvinteTeclasBloqueadas().getTeclasEspeciais());
		sobrenome.setBounds(140, 125, 200, 20);
		add(sobrenome);
	}
	
	private void caixaEmail() {
		textoEmail = new JLabel("Email:");
		textoEmail.setBounds(30, 165, 100, 19);
		add(textoEmail);
		
		email = new CaixaTextoPadrao();
		email.addKeyListener(new OuvinteTeclasEspeciais());
		email.setToolTipText(new OuvinteTeclasEspeciais().getTeclasEspeciais());
		email.setBounds(140, 165, 200, 20);
		add(email);
	}
	
	private void caixaSenha(){
		textoSenha = new TextoImagemPadrao("Senha:");
		textoSenha.setBounds(30, 205, 100, 19);
		add(textoSenha);
		
		senha = new CaixaPadraoSenha();
		senha.addKeyListener(new OuvinteTeclasEspeciais());
		senha.setToolTipText(new OuvinteTeclasEspeciais().getTeclasEspeciais());
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

	private class OuvinteComponentesPreenchidosDeDados implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			if(nome.getText().equals(""))
				nome.setBorder(getBordaErro());
			else nome.setBorder(getBorda());
			
			if(sobrenome.getText().equals(""))
				sobrenome.setBorder(getBordaErro());
			else sobrenome.setBorder(getBorda());
			
			if(email.getText().equals(""))
				email.setBorder(getBordaErro());
			else email.setBorder(getBorda());
			if(new String(senha.getPassword()).length() < 4 || new String(senha.getPassword()).equals("")) 
				senha.setBorder(getBordaErro());
			else senha.setBorder(getBorda());
			
			if(!feminino.isSelected() && !masculino.isSelected())	{
				feminino.setForeground(new Color(231, 110, 84));
				masculino.setForeground(new Color(231, 110, 84));
			}
			else {
				feminino.setForeground(null);
				masculino.setForeground(null);
			}
			
			if(!nome.getText().equals("") && !sobrenome.getText().equals("") && !email.getText().equals("") && !new String(senha.getPassword()).equals("") && new String(senha.getPassword()).length() > 3 && (feminino.isSelected() | masculino.isSelected())) {
				try {
					Administrador adm = new Administrador(nome.getText(), email.getText(), new String(senha.getPassword()), (feminino.isSelected()) ? Sexo.F : Sexo.M);
					Random c = new Random();
					String codigo = Integer.toString(c.nextInt(1000,9999));
					
					Mensageiro.enviarHistoricoCorridas(getEmail().getText(), codigo);
					dispose();
					
					new JanelaConfirmarEmail(codigo, adm);
					
				} catch (Exception e1) {
					new JanelaDeAvisoPadrao("E-mail incorreto ou inexistente", primeiroAcesso);
				}
				
			}
		}
	}
}
