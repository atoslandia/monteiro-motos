package projeto_poo.janelas;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	

	private JTextField codigo;
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
		codigo();
		
	}
	
	private void botaoPadraoProsseguir() {
		botaoPadraoProsseguir = new BotaoPadrao("Clique para prosseguir");
		botaoPadraoProsseguir.setIcon(new ImageIcon("imgs/botao-prosseguir.png"));
		botaoPadraoProsseguir.setPressedIcon(new ImageIcon("imgs/botao-prosseguirclicado.png"));
	}
	
	private void botaoPadraoCancelar() {
		botaoPadraoCancelar = new BotaoPadrao("Clique para cancelar e voltar");
		botaoPadraoCancelar.setIcon(new ImageIcon("imgs/botao-voltar.png"));
		botaoPadraoCancelar.setPressedIcon(new ImageIcon("imgs/botao-voltarclicado.png"));
	}
	
	private void botaoPadraoConcluir() {
		botaoPadraoConcluir = new BotaoPadrao("Clique para concluir");
		botaoPadraoConcluir.setIcon(new ImageIcon("imgs/botao-concluir.png"));
		botaoPadraoConcluir.setPressedIcon(new ImageIcon("imgs/botao-concluirclicado.png"));
	}
	
	private void fundoPadrao() {
		fundoPadrao = new TextoImagemPadrao(new ImageIcon("imgs/fundo-padrao.png"));
		fundoPadrao.setBounds(15, -7, 768, 406);
	}
	
	private void codigo() {
		textoCodigo = new JLabel("Código:");
		textoCodigo.setFont(getFont());
		add(textoCodigo);
		
		codigo = new JTextField();
		codigo.setFont(getFont());
		codigo.addKeyListener(getTeclasEspeciais());
		codigo.setToolTipText(getTeclasEspeciais().getTeclasEspeciais());
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

	public JLabel getTextoCodigo() {
		return textoCodigo;
	}

	public JTextField getCodigo() {
		return codigo;
	}

	public OuvinteTeclasBloqueadas getTeclasBloqueadas() {
		return teclasBloqueadas;
	}

	public OuvinteTeclasEspeciais getTeclasEspeciais() {
		return teclasEspeciais;
	}

}