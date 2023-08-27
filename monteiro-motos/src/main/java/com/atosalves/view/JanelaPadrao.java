package com.atosalves.view;

import java.awt.Font;
import javax.swing.JFrame;

public abstract class JanelaPadrao extends JFrame {

	public JanelaPadrao() {
		setSize(760, 420);
		setFont(new Font("Calibrii", Font.BOLD | Font.ITALIC, 12));
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
