package com.atosalves.view.componentes;

import com.atosalves.view.util.Tema;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Botao extends JButton implements Componente {

	public Botao(String titulo) {
		setText(titulo);
		setToolTipText(titulo);
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

		g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, 35, 35);

		super.paintComponent(g);
	}

	public void aoClicar(Runnable aoClicar) {
		ActionListener ouvinte = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aoClicar.run();
			}
		};

		addActionListener(ouvinte);
	}

	public void teste() {}
}
