package projeto_poo.janelas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import projeto_poo.Persistencia;
import projeto_poo.botoes.BotaoPadrao;
import projeto_poo.diversos.TextoImagemPadrao;


public class JanelaPadrao extends JFrame{
	
	private Border borda = BorderFactory.createMatteBorder(1,1,1,1, Color.BLACK);
	private Border bordaErro = BorderFactory.createMatteBorder(2,2,2,2, new Color(231, 110, 84));
	private Persistencia persistencia = new Persistencia();
	
	public JanelaPadrao(String tituloJanela) {
		
		setTitle(tituloJanela);
		setSize(760, 420);
		setFont(new Font("Calibrii", Font.BOLD | Font.ITALIC, 12));
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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