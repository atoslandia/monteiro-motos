package projeto_poo.botoes;

import java.awt.Font;
import javax.swing.ImageIcon;
import projeto_poo.diversos.TextoImagemPadrao;

public class BotaoOpcoes extends BotaoPadrao{
	
	private String titulo;
	
	public BotaoOpcoes(String titulo) {
		super();
		this.titulo = titulo;
		texto();
		setIcon(new ImageIcon("imgs/botao-padraoinicio.png"));
		setPressedIcon(new ImageIcon("imgs/botao-padraoinicioclicado.png"));
		setBounds(30, 100, 358, 35);
	}
	
	private void texto() {
		TextoImagemPadrao t = new TextoImagemPadrao(titulo);
		t.setFont(new Font("Calibrii", Font.BOLD, 14));
		add(t);
	}
	
}


