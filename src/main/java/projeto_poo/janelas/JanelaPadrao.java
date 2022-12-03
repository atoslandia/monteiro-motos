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
		
		criarBotoesPadrao();
		
		gerarCodigo();
		
	}
	
	private JButton botaoPadraoProsseguir;
	private JButton botaoPadraoVoltar;
	private JButton botaoPadraoConcluir;

	private JLabel fundoPadrao;
	private JLabel barra;
	
	private int codigo;

	private void criarBotoesPadrao() {
		botaoPadraoProsseguir = new BotaoPadrao("Clique para prosseguir", "imgs/botao-prosseguir.png","imgs/botao-prosseguirclicado.png");
		botaoPadraoVoltar = new BotaoPadrao("Clique para prosseguir", "imgs/botao-prosseguir.png","imgs/botao-prosseguirclicado.png");
		botaoPadraoConcluir = new BotaoPadrao("Clique para prosseguir", "imgs/botao-prosseguir.png","imgs/botao-prosseguirclicado.png");
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