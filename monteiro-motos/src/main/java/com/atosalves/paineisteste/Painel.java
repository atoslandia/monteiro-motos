package com.atosalves.paineisteste;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lombok.Getter;
import lombok.Setter;

public class Painel extends JPanel {

	@Setter
	private Image fundo;

	public Painel() {
		setLayout(null);
	}

	protected void setPainel(Painel painel) {
		JanelaPrincipal janela = (JanelaPrincipal) SwingUtilities.getWindowAncestor(this);

		janela.setPainel(painel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// TODO: mudar fundo depois
		g.drawImage(fundo, 0, 0, this);
	}
}
