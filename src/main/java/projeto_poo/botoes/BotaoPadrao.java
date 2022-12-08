package projeto_poo.botoes;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BotaoPadrao extends JButton{
	
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

	public BotaoPadrao() {
		setContentAreaFilled(false);
		setBorderPainted(false);
		setCursor(cursor);
	}
	
}
