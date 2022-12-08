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
import projeto_poo.diversos.OpcaoRadioPadrao;
import projeto_poo.diversos.TextoImagemPadrao;

public class PainelEntradas extends PainelPadrao{
	
	private CaixaNomeSobrenome nome;
	private CaixaNomeSobrenome sobrenome;
	private CaixaEmail email;
	private CaixaSenha senha;
	private JRadioButton feminino;
	private JRadioButton masculino;
	private JComboBox<String> dia;
	private JComboBox<String> mes;
	private JComboBox<String> ano;
	
	private TextoImagemPadrao avisoPreencherDados;
	private TextoImagemPadrao avisoUsuarioExiste;
	
	public PainelEntradas() {
		super();
		caixaNome();
		caixaSobrenome();
		caixaEmail();
		caixaSenha();
		escolhaSexo();
		dataNascimento();
		avisos();
	}
	
	private void avisos() {
    	avisoPreencherDados = new TextoImagemPadrao("Preencha todos os dados!");
    	avisoPreencherDados.setForeground(Color.RED);
    	avisoPreencherDados.setVisible(false);
    	avisoPreencherDados.setBounds(120, 65, 150, 20);
    	add(avisoPreencherDados);
    	
    	avisoUsuarioExiste = new TextoImagemPadrao("Usuário já cadastrado!");
    	avisoUsuarioExiste.setForeground(Color.RED);
    	avisoUsuarioExiste.setVisible(false);
    	avisoUsuarioExiste.setBounds(120, 65, 150, 20);
    	add(avisoUsuarioExiste);
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
		
		feminino = new OpcaoRadioPadrao("Feminino");
		feminino.setBounds(140, 205, 100, 20);
		add(feminino);
		
		masculino = new OpcaoRadioPadrao("Masculino");
		masculino.setBounds(255, 205, 100, 20);
		add(masculino);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.getSelection();
		grupo.add(feminino);
		grupo.add(masculino);
	}
	
	private void dataNascimento() {
		TextoImagemPadrao textoTipoDeConta = new TextoImagemPadrao("Nascimento: (dia/mês/ano)");
		textoTipoDeConta.setBounds( 30, 235, 160,20);
		add(textoTipoDeConta);
		
		String[] meses = new String[12];
		String[] dias = new String[31];
		String[] anos = new String[101];
		
		for(int i = 0; i < anos.length; i++) {
			if(i < meses.length)
				meses[i] = Integer.toString(i+1);
			if(i < dias.length)
				dias[i] = Integer.toString(i+1);
			anos[i] = Integer.toString(LocalDate.now().getYear()-i);
		}
		
		dia = new JComboBox<String>(dias);
		dia.setBounds(190, 235, 45, 20);
		add(dia);
		mes = new JComboBox<String>(meses);
		mes.setBounds(240, 235, 45, 20);
		add(mes);
		ano = new JComboBox<String>(anos);
		ano.setBounds(290, 235, 60, 20);
		ano.setSelectedIndex(18);
		add(ano);
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

	public JRadioButton getFeminino() {
		return feminino;
	}

	public JRadioButton getMasculino() {
		return masculino;
	}

	public JComboBox<String> getDia() {
		return dia;
	}

	public JComboBox<String> getMes() {
		return mes;
	}

	public JComboBox<String> getAno() {
		return ano;
	}
	
	public TextoImagemPadrao getAvisoPreencherDados() {
		return avisoPreencherDados;
	}

	public TextoImagemPadrao getAvisoUsuarioExiste() {
		return avisoUsuarioExiste;
	}

}
