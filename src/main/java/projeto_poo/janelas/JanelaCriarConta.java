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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import projeto_poo.Administrador;
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
import projeto_poo.erros.NaoExisteXmlException;
import projeto_poo.erros.UsuarioNaoExisteException;
import projeto_poo.ouvintes.OuvinteTeclasBloqueadas;
import projeto_poo.ouvintes.OuvinteTeclasEspeciais;

public class JanelaCriarConta extends JanelaPadrao{
	
	private JanelaCriarConta estaJanela;

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
	
	private JLabel avisoPreencherDados;
	private JLabel avisoUsuarioExiste;
	
	public JanelaCriarConta() {
		super("Criar conta");
		caixaNome();
		caixaSobrenome();
		caixaEmail();
		caixaSenha();
		escolhaSexo();
		tipoDeConta();
		dataNascimento();
		
		botaoProsseguir();
		botaoVoltar();
		
		avisos();
		
		logoCadastro();
		add(getFundoPadrao());
		setVisible(true);
	}
	
	public JanelaCriarConta(String primeiroCadastro) {
		super("Criar conta");
		setTitle(primeiroCadastro);
		caixaNome();
		caixaSobrenome();
		caixaEmail();
		caixaSenha();
		escolhaSexo();
		dataNascimento();
		
		botaoProsseguirAdm();
		
		avisos();
		
		logoPrimeiroAcesso();
		add(getFundoPadrao());
		setVisible(true);
	}
	
	private void logoCadastro() {
		JLabel logo = new JLabel(new ImageIcon("imgs/criarconta.png"));
		logo.setBounds(30, 30, 282, 32);
		add(logo);
	}
	
	private void logoPrimeiroAcesso() {
		JLabel logo = new JLabel(new ImageIcon("imgs/primeiroacesso.png"));
		logo.setBounds(30, 30, 394, 32);
		add(logo);
	}
	
	private void botaoProsseguir() {
		JButton botaoProsseguir = getBotaoProsseguir();
		botaoProsseguir.setBounds(530, 170, 170, 41);
		
		botaoProsseguir.addActionListener(new OuvinteBotaoProsseguir());
		add(botaoProsseguir);
	}
	
	private void botaoProsseguirAdm() {
		JButton botaoProsseguir = getBotaoProsseguir();
		botaoProsseguir.setBounds(530, 170, 170, 41);
		
		botaoProsseguir.addActionListener(new OuvinteBotaoProsseguirAdm());
		add(botaoProsseguir);
	}
	
	private void botaoVoltar() {
		JButton botaoVoltar = getBotaoVoltar();
		botaoVoltar.setBounds(590, 220, 58, 22);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltar());
		
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
	
	private class OuvinteBotaoProsseguir implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {

			avisoPreencherDados.setVisible(false);
			avisoUsuarioExiste.setVisible(false);
			
			if(!nome.getText().equals("") && !sobrenome.getText().equals("") && !email.getText().equals("")
					&& !new String(senha.getPassword()).equals("") && new String(senha.getPassword()).length() > 3
					&& (feminino.isSelected() | masculino.isSelected()) && (passageiro.isSelected() | mototaxista.isSelected())) {
				String n = nome.getText();
				String sn = sobrenome.getText();
				LocalDate data = LocalDate.of(Integer.parseInt((String)ano.getSelectedItem()), Integer.parseInt((String)mes.getSelectedItem()), Integer.parseInt((String)dia.getSelectedItem()));
				Sexo sexo = feminino.isSelected() ? Sexo.F : Sexo.M;
				try {
					
					getPersistencia().buscarCentral().recuperarUsuarioPeloEmail(email.getText());
					avisoUsuarioExiste.setVisible(true);
					
				} catch (UsuarioNaoExisteException e2) {
					try {
						Random c = new Random();
						String codigo = Integer.toString(c.nextInt(1000,9999));
						Mensageiro.enviarCodigoEmail(email.getText(), codigo);
						
						Usuario usuario = (passageiro.isSelected())? new Passageiro(n , sn , data, sexo, email.getText(), new String(senha.getPassword()))
								: new Mototaxista(n , sn , data, sexo, email.getText(), new String(senha.getPassword()));
						
						new JanelaConfirmarEmail(codigo, usuario);
						dispose();
					} catch (Exception e1) {
						System.out.println(e1);
						new JanelaDeAvisoPadrao("E-mail incorreto ou inexistente", estaJanela);
					}
				} catch (Exception e2) {
					System.out.println(e2);
				}
			} else
			 	avisoPreencherDados.setVisible(true);
		}
	}
	
	private class OuvinteBotaoProsseguirAdm implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			avisoPreencherDados.setVisible(false);
			avisoUsuarioExiste.setVisible(false);
			
			if(!nome.getText().equals("") && !sobrenome.getText().equals("") && !email.getText().equals("")
					&& !new String(senha.getPassword()).equals("") && new String(senha.getPassword()).length() > 3
					&& (feminino.isSelected() | masculino.isSelected())) {
				String n = nome.getText();
				String sn = sobrenome.getText();
				LocalDate data = LocalDate.of(Integer.parseInt((String)ano.getSelectedItem()), Integer.parseInt((String)mes.getSelectedItem()), Integer.parseInt((String)dia.getSelectedItem()));
				Sexo sexo = feminino.isSelected() ? Sexo.F : Sexo.M;
				try {

					Random c = new Random();
					String codigo = Integer.toString(c.nextInt(1000,9999));
					
					Mensageiro.enviarCodigoEmail(email.getText(), codigo);
					Administrador adm = new Administrador(n, sn, data, sexo, email.getText(), new String(senha.getPassword()));
					new JanelaConfirmarEmail(codigo, adm);

					dispose();
					
				} catch (Exception e1) {
					System.out.println(e1);
					new JanelaDeAvisoPadrao("E-mail incorreto ou inexistente", estaJanela);
				}
				
			}else 
				avisoPreencherDados.setVisible(true);
		}
	}
	
	private class OuvinteBotaoVoltar implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			dispose();
			new JanelaLogin();
		}
	}
	
}
