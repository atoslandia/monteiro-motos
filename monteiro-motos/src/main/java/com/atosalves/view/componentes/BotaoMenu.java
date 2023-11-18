package com.atosalves.view.componentes;

import com.atosalves.view.util.Tema;
import java.awt.Graphics;

public class BotaoMenu extends Botao {

	public BotaoMenu() {
		setFont(Tema.FONTE_MUITO_FORTE);
		setForeground(Tema.AMARELO);
		setBackground(Tema.PRETO);
		setFocusPainted(false);
	}

	public BotaoMenu desativado() {
		setEnabled(false);
		return this;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Tema.AMARELO_ESCURO);
			setForeground(Tema.PRETO);
		} else {
			g.setColor(getBackground());
			setForeground(Tema.AMARELO);
		}

		g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

		super.paintComponent(g);
	}
}
