package projeto_poo.paineis;

import java.awt.Color;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import projeto_poo.caixas.CaixaEmail;
import projeto_poo.caixas.CaixaNomeSobrenome;
import projeto_poo.caixas.CaixaSenha;
import projeto_poo.diversos.ComboDataNascimento;
import projeto_poo.diversos.EscolhaSexo;
import projeto_poo.diversos.TextoImagemPadrao;

public class PainelEntradas extends PainelPadrao{
	
	private CaixaNomeSobrenome nome;
	private CaixaNomeSobrenome sobrenome;
	private CaixaEmail email;
	private CaixaSenha senha;
	private EscolhaSexo sexo;
	private ComboDataNascimento dataNascimento;
	
	public PainelEntradas() {
		super();
		caixaNome();
		caixaSobrenome();
		caixaEmail();
		caixaSenha();
		escolhaSexo();
		dataNascimento();
	}
	
	private void caixaNome(){
		JLabel textoNome = new TextoImagemPadrao("Nome:");
		textoNome.setBounds(30, 85, 100, 19);
		add(textoNome);
		
		nome = new CaixaNomeSobrenome();
		nome.setBounds(120, 85, 230, 20);
		add(nome);
	}
	
	private void caixaSobrenome(){
		TextoImagemPadrao textoSobrenome = new TextoImagemPadrao("Sobrenome:");
		textoSobrenome.setBounds(30, 115, 100, 19);
		add(textoSobrenome);
		
		sobrenome = new CaixaNomeSobrenome();
		sobrenome.setBounds(120, 115, 230, 20);
		add(sobrenome);
	}
	
	private void caixaEmail() {
		JLabel textoEmail = new JLabel("Email:");
		textoEmail.setBounds(30, 145, 100, 19);
		add(textoEmail);
		
		email = new CaixaEmail();
		email.setBounds(120, 145, 230, 20);
		add(email);
	}
	
	private void caixaSenha(){
		TextoImagemPadrao textoSenha = new TextoImagemPadrao("Senha:");
		textoSenha.setBounds(30, 175, 100, 19);
		add(textoSenha);
		
		senha = new CaixaSenha();
		senha.setBounds(120, 175, 230, 20);
		add(senha);
	}
	
	private void escolhaSexo() {
		TextoImagemPadrao textoSexo = new TextoImagemPadrao("Sexo:");
		textoSexo.setBounds(30, 205, 100, 19);
		add(textoSexo);
		
		sexo = new EscolhaSexo();
		add(sexo.getFeminino());
		add(sexo.getMasculino());
	}
	
	private void dataNascimento() {
		TextoImagemPadrao textoTipoDeConta = new TextoImagemPadrao("Nascimento: (dia/mês/ano)");
		textoTipoDeConta.setBounds( 30, 235, 160,20);
		add(textoTipoDeConta);
		
		dataNascimento = new ComboDataNascimento();
		add(dataNascimento.getDia());
		add(dataNascimento.getMes());
		add(dataNascimento.getAno());
	}
	
	public CaixaNomeSobrenome getNome() {
		return nome;
	}

	public CaixaNomeSobrenome getSobrenome() {
		return sobrenome;
	}

	public CaixaEmail getEmail() {
		return email;
	}

	public CaixaSenha getSenha() {
		return senha;
	}

	public EscolhaSexo getSexo() {
		return sexo;
	}

	public ComboDataNascimento getDataNascimento() {
		return dataNascimento;
	}
	
}
