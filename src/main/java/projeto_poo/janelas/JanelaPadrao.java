package projeto_poo.janelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import projeto_poo.Persistencia;
import projeto_poo.botoes.BotaoPadrao;
import projeto_poo.diversos.TextoImagemPadrao;


public abstract class JanelaPadrao extends JFrame{
	
	private Border borda = BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK);
	private Border bordaErro = BorderFactory.createMatteBorder(2,2,2,2, new Color(231, 110, 84));
	private Persistencia persistencia = new Persistencia();
	private TextoImagemPadrao fundoPadrao;
	private TextoImagemPadrao avisoPreencherDados;

	
	public JanelaPadrao(String tituloJanela) {
		
		setTitle(tituloJanela);
		setSize(760, 420);
		setFont(new Font("Calibrii", Font.BOLD | Font.ITALIC, 12));
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fundoPadrao();
		avisos();
	}
	
	private void avisos() {
    	avisoPreencherDados = new TextoImagemPadrao("Preencha todos os dados!");
    	avisoPreencherDados.setForeground(Color.RED);
    	avisoPreencherDados.setVisible(false);
    	avisoPreencherDados.setBounds(120, 65, 150, 20);
    	add(avisoPreencherDados);
    }

	private void fundoPadrao() {
		fundoPadrao = new TextoImagemPadrao(new ImageIcon("imgs/fundo-padrao.png"));
		fundoPadrao.setBounds(15, -7, 768, 406);
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
	
	public TextoImagemPadrao getFundoPadrao() {
		return fundoPadrao;
	}
	
	public TextoImagemPadrao getAvisoPreencherDados() {
		return avisoPreencherDados;
	}

}