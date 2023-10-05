package com.atosalves.view;

import com.atosalves.view.paineis.PainelPadrao;
import java.awt.Font;
import javax.swing.JFrame;

public class JanelaPrincipal extends JFrame {

	public JanelaPrincipal() {
		setSize(760, 420);
		setFont(new Font("Calibrii", Font.BOLD | Font.ITALIC, 12));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MONTEIRO MOTOS");
		setVisible(true);
	}

	public void setPainel(PainelPadrao painel) {
		getContentPane().removeAll();
		getContentPane().add(painel);
		revalidate();
		repaint();
	}
}
