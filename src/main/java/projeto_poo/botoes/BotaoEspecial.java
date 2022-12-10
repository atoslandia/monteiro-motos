package projeto_poo.botoes;

import java.awt.ComponentOrientation;
import java.awt.Font;

import javax.swing.ImageIcon;

import projeto_poo.diversos.TextoImagemPadrao;

public class BotaoEspecial extends BotaoPadrao{
	private String titulo;
	
	public BotaoEspecial(String titulo) {
		this.titulo = titulo;
		texto();
		setIcon(new ImageIcon("imgs/botao-especial.png"));
		setPressedIcon(new ImageIcon("imgs/botao-especialclicado.png"));
		setBounds(510, 120, 209, 36);
		setLayout(null);
	}
	
	private void texto() {
		TextoImagemPadrao t = new TextoImagemPadrao(titulo);
		t.setFont(new Font("Calibrii", Font.BOLD, 14));
		t.setBounds((209/2)-(t.getText().length()*4),0,209,36);
		add(t);
	}
}
