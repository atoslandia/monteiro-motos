package projeto_poo.janelas;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import projeto_poo.CentralDeInformacoes;
import projeto_poo.Persistencia;
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
		
	}
	private Border borda = BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK);
	private Border bordaErro = BorderFactory.createMatteBorder(2,2,2,2, new Color(231, 110, 84));
	
	
	private Persistencia persistencia = new Persistencia();
	
	
	private JButton botaoPadraoProsseguir;
	private JButton botaoPadraoVoltar;
	private JButton botaoPadraoConcluir;

	private JLabel fundoPadrao;
	private JLabel barra;
	
	private void criarBotoesPadrao() {
		botaoPadraoProsseguir = new BotaoPadrao("Clique para prosseguir", "imgs/botao-prosseguir.png","imgs/botao-prosseguirclicado.png");
		botaoPadraoVoltar = new BotaoPadrao("Clique para prosseguir", "imgs/botao-voltar.png","imgs/botao-voltarclicado.png");
		botaoPadraoConcluir = new BotaoPadrao("Clique para prosseguir", "imgs/botao-concluir.png","imgs/botao-concluirclicado.png");
	}
	
	private void fundoPadrao() {
		fundoPadrao = new TextoImagemPadrao(new ImageIcon("imgs/fundo-padrao.png"));
		fundoPadrao.setBounds(15, -7, 768, 406);
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

	public Persistencia getPersistencia() {
		return persistencia;
	}

	public Border getBorda() {
		return borda;
	}

	public Border getBordaErro() {
		return bordaErro;
	}



}