package com.atosalves.view.componentes;

import com.atosalves.view.util.Tema;
import java.awt.Graphics;
import javax.swing.JButton;
import lombok.Setter;

public class Botao extends JButton {

	@Setter
	private int larguraCurva = 35;

	@Setter
	private int alturaCurva = 35;

	public Botao() {
		setBackground(Tema.AMARELO);
		setForeground(Tema.PRETO);
		setFont(Tema.FONTE_FORTE);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			g.setColor(Tema.AMARELO_ESCURO);
		} else {
			g.setColor(getBackground());
		}

		g.fillRoundRect(
			0,
			0,
			getSize().width - 1,
			getSize().height - 1,
			larguraCurva,
			alturaCurva
		);

		super.paintComponent(g);
	}

	public void aoClicar(Runnable aoClicar) {
		addActionListener(evento -> aoClicar.run());
	}
}
