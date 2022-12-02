package projeto_poo.janelas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import projeto_poo.ouvintes.OuvinteTeclasBloqueadas;
import projeto_poo.ouvintes.OuvinteTeclasEspeciais;


public class JanelaPadrao extends JFrame{
	
	private OuvinteTeclasBloqueadas teclasBloqueadas = new OuvinteTeclasBloqueadas();
	private OuvinteTeclasEspeciais teclasEspeciais = new OuvinteTeclasEspeciais();
	
	private JButton botaoPadraoProsseguir;
	private JButton botaoPadraoCancelar;
	private JButton botaoPadraoConcluir;
	
	private JLabel fundoPadrao;
	private JLabel barra;
	
	private JTextField nome;
	private JTextField sobrenome;
	private JTextField email;
	private JPasswordField senha;
	private ButtonGroup grupo;
	private JRadioButton feminino;
	private JRadioButton masculino;
	private JTextField codigo;

	private JLabel textoNome;
	private JLabel textoSobrenome;
	private JLabel textoEmail;
	private JLabel textoSenha;
	private JLabel textoSexo;
	private JLabel textoCodigo;
	
	public JanelaPadrao(String tituloJanela) {
		
		/* ouvintes */
		
		/* padrao da janela */
		setTitle(tituloJanela);
		setSize(760, 420);
		setFont(new Font("Calibrii", Font.BOLD | Font.ITALIC, 12));
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/* fundo */
		fundoPadrao();
		
		/* botoes e imagens*/
		botaoPadraoProsseguir();
		botaoPadraoCancelar();
		botaoPadraoConcluir();
		
		/* caixas e textos */
		nome();
		sobrenome();
		email();
		senha();
		sexo();
		codigo();
		
	}
	
	private void botaoPadraoProsseguir() {
		botaoPadraoProsseguir = new JButton();
		botaoPadraoProsseguir.setContentAreaFilled(false);
		botaoPadraoProsseguir.setBorderPainted(false);
		botaoPadraoProsseguir.setIcon(new ImageIcon("imgs/botao-prosseguir.png"));
		botaoPadraoProsseguir.setPressedIcon(new ImageIcon("imgs/botao-prosseguirclicado.png"));
	}
	
	private void botaoPadraoCancelar() {
		botaoPadraoCancelar = new JButton();
		botaoPadraoCancelar.setContentAreaFilled(false);
		botaoPadraoCancelar.setBorderPainted(false);
		botaoPadraoCancelar.setIcon(new ImageIcon("imgs/botao-cancelar.png"));
		botaoPadraoCancelar.setPressedIcon(new ImageIcon("imgs/botao-cancelarclicado.png"));
	}
	
	private void botaoPadraoConcluir() {
		botaoPadraoConcluir = new JButton();
		botaoPadraoConcluir.setContentAreaFilled(false);
		botaoPadraoConcluir.setBorderPainted(false);
		botaoPadraoConcluir.setIcon(new ImageIcon("imgs/botao-concluir.png"));
		botaoPadraoConcluir.setPressedIcon(new ImageIcon("imgs/botao-concluirclicado.png"));
	}
	
	private void fundoPadrao() {
		fundoPadrao = new JLabel(new ImageIcon("imgs/fundo-padrao.png"));
		fundoPadrao.setBounds(15, -7, 768, 406);
	}
	
	private void nome() {
		textoNome = new JLabel("Nome:");
		textoNome.setFont(getFont());
		add(textoNome);
		
		nome = new JTextField();
		nome.setSelectionColor(new Color(255, 204, 0));
		nome.setFont(getFont());
		nome.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
		nome.addKeyListener(teclasBloqueadas);
		nome.setToolTipText(teclasBloqueadas.getTeclasEspeciais());
		add(nome);
	}
	
	private void sobrenome() {
		textoSobrenome = new JLabel("Sobrenome:");
		textoSobrenome.setFont(getFont());
		add(textoSobrenome);
		
		sobrenome = new JTextField();
		sobrenome.setSelectionColor(new Color(255, 204, 0));
		sobrenome.setFont(getFont());
		sobrenome.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
		sobrenome.addKeyListener(teclasBloqueadas);
		sobrenome.setToolTipText(teclasBloqueadas.getTeclasEspeciais());
		add(sobrenome);
	}
	
	private void email() {
		textoEmail = new JLabel("Email:");
		textoEmail.setFont(getFont());
		add(textoEmail);
		
		email = new JTextField();
		email.setSelectionColor(new Color(255, 204, 0));
		email.setFont(getFont());
		email.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
		email.addKeyListener(teclasEspeciais);
		email.setToolTipText(teclasEspeciais.getTeclasEspeciais());
		add(email);
	}
	
	private void senha() {
		textoSenha = new JLabel("Senha:");
		textoSenha.setFont(getFont());
		add(textoSenha);
		
		senha = new JPasswordField();
		senha.setSelectionColor(new Color(255, 204, 0));
		senha.setFont(getFont());
		senha.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK));
		senha.addKeyListener(teclasEspeciais);
		senha.setToolTipText(teclasEspeciais.getTeclasEspeciais());
		add(senha);
	}
	
	private void sexo() {
		textoSexo = new JLabel("Sexo:");
		textoSexo.setFont(getFont());
		add(textoSexo);
		
		feminino = new JRadioButton("Feminino");
		feminino.setFont(getFont());
		add(feminino);
		
		masculino = new JRadioButton("Masculino");
		masculino.setFont(getFont());
		add(masculino);
		
		grupo = new ButtonGroup();
		grupo.getSelection();
		grupo.add(feminino);
		grupo.add(masculino);
	}
	
	private void codigo() {
		textoCodigo = new JLabel("Código:");
		textoCodigo.setFont(getFont());
		add(textoCodigo);
		
		codigo = new JTextField();
		codigo.setFont(getFont());
		codigo.addKeyListener(teclasEspeciais);
		codigo.setToolTipText(teclasEspeciais.getTeclasEspeciais());
		add(codigo);
	}

	public JLabel getBarra() {
		return barra;
	}

	public JLabel getFundoPadrao() {
		return fundoPadrao;
	}

	public JButton getBotaoProsseguir() {
		return botaoPadraoProsseguir;
	}
	
	public JButton getBotaoCancelar() {
		return botaoPadraoCancelar;
	}
	
	public JButton getBotaoConcluir() {
		return botaoPadraoConcluir;
	}
	
	public JLabel getTextoNome() {
		return textoNome;
	}

	public JLabel getTextoSobrenome() {
		return textoSobrenome;
	}
	
	public JLabel getTextoEmail() {
		return textoEmail;
	}

	public JLabel getTextoSenha() {
		return textoSenha;
	}

	public JLabel getTextoSexo() {
		return textoSexo;
	}
	
	public JLabel getTextoCodigo() {
		return textoCodigo;
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
	
	public ButtonGroup getGrupo() {
		return grupo;
	}

	public JRadioButton getFeminino() {
		return feminino;
	}
	
	public JRadioButton getMasculino() {
		return masculino;
	}
	
	public JTextField getCodigo() {
		return codigo;
	}

}