package projeto_poo.janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import projeto_poo.ouvintes.OuvinteComponentesPreenchidosDeDados;

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
		getTextoNome().setBounds(30, 85, 100, 19);
		getNome().setBounds(140, 85, 200, 20);
	}
	private void caixaSobrenome(){
		getTextoSobrenome().setBounds(30, 125, 100, 19);
		getSobrenome().setBounds(140, 125, 200, 20);
	}
	
	private void caixaEmail() {
		getTextoEmail().setBounds(30, 165, 100, 19);
		getEmail().setBounds(140, 165, 200, 20);
	}
	
	private void caixaSenha(){
		getTextoSenha().setBounds(30, 205, 100, 19);
		getSenha().setBounds(140, 205, 200, 20);
	}
	
	private void escolhaSexo() {
		getTextoSexo().setBounds(30, 245, 100, 19);
		getFeminino().setBounds(140, 245, 100, 20);
		getMasculino().setBounds(250, 245, 100, 20);
	}
	
	private class OuvinteBotaoPrimeiroAcesso implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//componente.setBorder(BorderFactory.createMatteBorder(1,1,1,1, new Color(231, 110, 84)));
			System.out.println("ao clicar em prosseguir, primeiro deve"
							 + "\nverificar se todos os componentes foram"
							 + "\npreenchidos, se sim, ir para a tela de"
							 + "\nverificacao do email, e se o codigo estiver"
							 + "\ncorreto, ir para a tela de login, caso nao"
							 + "\nestiver, voltar para preencher os dados novamente");
			
//			if(!getNome().getText().equals("") && !getEmail().getText().equals("") && ! new String(getSenha().getPassword()).equals("") && getFeminino().isSelected()) 
//				adm = new Administrador(getNome().getText(), getEmail().getText(), new String(getSenha().getPassword()), Sexo.F);
//			else if(!getNome().getText().equals("") && !getEmail().getText().equals("") && ! new String(getSenha().getPassword()).equals("") && getMasculino().isSelected())
//				adm = new Administrador(getNome().getText(), getEmail().getText(), new String(getSenha().getPassword()), Sexo.M);
		}
	}
}
