package com.atosalves.view.abstractfactory;

import com.atosalves.view.util.Tema;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class Botao extends JButton {

	private int arcWidth = 35;
	private int arcHeight = 35;

	public Botao(String titulo) {
		setText(titulo);
		setBackground(Tema.BOTAO_COR);
		setForeground(Tema.TEXTO_COR);
		setFont(Tema.TEXTO_FONTE);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Tema.BOTAO_FUNDO_COR);
		} else {
			g.setColor(getBackground());
		}

		g.fillRoundRect(
			0,
			0,
			getSize().width - 1,
			getSize().height - 1,
			arcWidth,
			arcHeight
		);

		super.paintComponent(g);
	}

	@Override
	public Dimension getPreferredSize() {
		// TODO alterar depois
		return new Dimension(100, 40);
	}
}
