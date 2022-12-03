package projeto_poo.janelas;

import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import projeto_poo.componentes.BotaoPadrao;
import projeto_poo.componentes.TextoImagemPadrao;
import projeto_poo.ouvintes.OuvinteTeclasBloqueadas;
import projeto_poo.ouvintes.OuvinteTeclasEspeciais;


public class JanelaPadrao extends JFrame{
	
	
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

		
		gerarCodigo();
		
	}
	
	private JButton botaoPadraoProsseguir;
	private JButton botaoPadraoVoltar;
	private JButton botaoPadraoConcluir;

	private JLabel fundoPadrao;
	private JLabel barra;
	
	private int codigo;

	private void botaoPadraoProsseguir() {
		botaoPadraoProsseguir = new BotaoPadrao("Clique para prosseguir");
		botaoPadraoProsseguir.setIcon(new ImageIcon("imgs/botao-prosseguir.png"));
		botaoPadraoProsseguir.setPressedIcon(new ImageIcon("imgs/botao-prosseguirclicado.png"));
	}
	
	private void botaoPadraoCancelar() {
		botaoPadraoVoltar = new BotaoPadrao("Clique para cancelar e voltar");
		botaoPadraoVoltar.setIcon(new ImageIcon("imgs/botao-voltar.png"));
		botaoPadraoVoltar.setPressedIcon(new ImageIcon("imgs/botao-voltarclicado.png"));
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
	
	private void gerarCodigo() {
		Random random = new Random();
		codigo = random.nextInt(1000, 9999);
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
	
	public JButton getBotaoVoltar() {
		return botaoPadraoVoltar;
	}
	
	public JButton getBotaoConcluir() {
		return botaoPadraoConcluir;
	}	

	public int getCodigo() {
		return codigo;
	}

}