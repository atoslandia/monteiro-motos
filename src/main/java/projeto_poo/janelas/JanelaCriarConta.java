package projeto_poo.janelas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Mensageiro;
import projeto_poo.Mototaxista;
import projeto_poo.Passageiro;
import projeto_poo.Sexo;
import projeto_poo.Usuario;
import projeto_poo.componentes.CaixaPadraoSenha;
import projeto_poo.componentes.CaixaTextoPadrao;
import projeto_poo.componentes.OpcaoRadioPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.ouvintes.OuvinteTeclasBloqueadas;
import projeto_poo.ouvintes.OuvinteTeclasEspeciais;

public class JanelaCriarConta extends JanelaPadrao{
	public JanelaCriarConta() {
		super("Criar conta");
		
		caixaNome();
		caixaSobrenome();
		caixaEmail();
		caixaSenha();
		escolhaSexo();
		tipoDeConta();
		dataNascimento();
		
		botaoConcluir();
		botaoVoltar();
		
		caixaCodigo();
		
		logoCadastro();
		add(getFundoPadrao());
		setVisible(true);
	}
	
	private JTextField nome;
	private JTextField sobrenome;
	private JTextField email;
	private JPasswordField senha;
	private JRadioButton feminino;
	private JRadioButton masculino;
	private JRadioButton passageiro;
	private JRadioButton mototaxista;
	private JComboBox<String> dia;
	private JComboBox<String> mes;
	private JComboBox<String> ano;
	
	private JTextField codigo;

	
	private void logoCadastro() {
		JLabel logo = new JLabel(new ImageIcon("imgs/criarconta.png"));
		logo.setBounds(30, 30, 282, 32);
		add(logo);
	}
	
	private void botaoConcluir() {
		JButton botaoProsseguir = getBotaoConcluir();
		botaoProsseguir.setBounds(530, 170, 170, 41);
		
		botaoProsseguir.addActionListener(new OuvinteComponentesPreenchidosDeDados());
			
		add(botaoProsseguir);
	}
	
	private void botaoVoltar() {
		JButton botaoVoltar = getBotaoVoltar();
		botaoVoltar.setBounds(590, 220, 58, 22);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltar());
		add(botaoVoltar);
	}
	
//	componentes
	private void caixaNome(){
		JLabel textoNome = new TextoImagemPadrao("Nome:");
		textoNome.setBounds(30, 85, 100, 19);
		add(textoNome);
		
		nome = new CaixaTextoPadrao();
		nome.addKeyListener(new OuvinteTeclasBloqueadas());
		nome.setToolTipText(new OuvinteTeclasBloqueadas().getTeclasEspeciais());
		nome.setBounds(120, 85, 230, 20);
		add(nome);
	}
	
	private void caixaSobrenome(){
		JLabel textoSobrenome = new TextoImagemPadrao("Sobrenome:");
		textoSobrenome.setBounds(30, 115, 100, 19);
		add(textoSobrenome);
		
		sobrenome = new CaixaTextoPadrao();
		sobrenome.addKeyListener(new OuvinteTeclasBloqueadas());
		sobrenome.setToolTipText(new OuvinteTeclasBloqueadas().getTeclasEspeciais());
		sobrenome.setBounds(120, 115, 230, 20);
		add(sobrenome);
	}
	
	private void caixaEmail() {
		JLabel textoEmail = new JLabel("Email:");
		textoEmail.setBounds(30, 145, 100, 19);
		add(textoEmail);
		
		email = new CaixaTextoPadrao();
		email.addKeyListener(new OuvinteTeclasEspeciais());
		email.setToolTipText(new OuvinteTeclasEspeciais().getTeclasEspeciais());
		email.setBounds(120, 145, 230, 20);
		add(email);
	}
	
	private void caixaSenha(){
		JLabel textoSenha = new TextoImagemPadrao("Senha:");
		textoSenha.setBounds(30, 175, 100, 19);
		add(textoSenha);
		
		senha = new CaixaPadraoSenha();
		senha.addKeyListener(new OuvinteTeclasEspeciais());
		senha.setToolTipText(new OuvinteTeclasEspeciais().getTeclasEspeciais());
		senha.setBounds(120, 175, 230, 20);
		add(senha);
	}
	
	private void escolhaSexo() {
		JLabel textoSexo = new TextoImagemPadrao("Sexo:");
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
		JLabel textoTipoDeConta = new TextoImagemPadrao("Nascimento: (dia/mês/ano)");
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
	
    private void tipoDeConta() {
        JLabel textoTipoDeConta = new TextoImagemPadrao("Tipo de Conta: ");
        textoTipoDeConta.setBounds(30 , 265, 100 ,20);
        add(textoTipoDeConta);
        passageiro = new OpcaoRadioPadrao("Passageiro");
        passageiro.setBounds(140, 265, 100, 20);
        add(passageiro);

        mototaxista = new OpcaoRadioPadrao("Mototaxista");
        mototaxista.setBounds(250, 265, 100, 20);
        add(mototaxista);

        ButtonGroup grupo = new ButtonGroup();
        grupo.getSelection();
        grupo.add(passageiro);
        grupo.add(mototaxista);
    }
    
    private void caixaCodigo() {
		JLabel textoCodigo = new JLabel("Código:");
		textoCodigo.setBounds(380, 65, 100, 19);
		textoCodigo.setVisible(false);
		add(textoCodigo);
		
		codigo = new CaixaTextoPadrao();
		codigo.addKeyListener(new OuvinteTeclasEspeciais());
		codigo.setToolTipText(new OuvinteTeclasEspeciais().getTeclasEspeciais());
		codigo.setBounds(380, 85, 70, 20);
		codigo.setVisible(false);
		add(codigo);
	}
	
	public JTextField getNome() {
		return nome;
	}
	
	public JTextField getSobrenome() {
		return sobrenome;
	}
	
	public JTextField getEmail() {
		return email;
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
	
	public JRadioButton getPassageiro() {
		return passageiro;
	}
	
	public JRadioButton getMototaxista() {
		return mototaxista;
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
			
			if(!passageiro.isSelected() && !mototaxista.isSelected())	{
				passageiro.setForeground(new Color(231, 110, 84));
				mototaxista.setForeground(new Color(231, 110, 84));
			}
			else {
				passageiro.setForeground(null);
				mototaxista.setForeground(null);
			}
			
			if(!nome.getText().equals("") && !sobrenome.getText().equals("") && !email.getText().equals("") && !new String(senha.getPassword()).equals("") && new String(senha.getPassword()).length() > 3 && (feminino.isSelected() | masculino.isSelected()) && (passageiro.isSelected() | mototaxista.isSelected())) {
				try {
					String n = nome.getText();
					String sn = sobrenome.getText();
					LocalDate data = LocalDate.of(Integer.parseInt((String)ano.getSelectedItem()), Integer.parseInt((String)mes.getSelectedItem()), Integer.parseInt((String)dia.getSelectedItem()));
					Sexo sexo = feminino.isSelected() ? Sexo.F : Sexo.M;
					
					
					
					Usuario usuario;
					if(passageiro.isSelected()) {
						usuario = new Passageiro(n , sn , data, sexo, email.getText(), new String(senha.getPassword()));
					}else {
						usuario = new Mototaxista(n , sn , data, sexo, email.getText(), new String(senha.getPassword()));
					}
					Random c = new Random();
					String codigo = Integer.toString(c.nextInt(1000,9999));
					
					Mensageiro.enviarHistoricoCorridas(email.getText(), codigo);
					dispose();
					
					new JanelaConfirmarEmail(codigo, usuario);
					
				} catch (Exception e2) {
					System.out.println("Acho que o email foi repetido"+e2);
				}
			}
		}
	}
	
	private class OuvinteBotaoVoltar implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaLogin();
		}
	}
	
}
