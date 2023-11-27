package com.atosalves.view.paineis;

import com.atosalves.view.componentes.Botao;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.JPanel;
import lombok.Setter;

public class Painel extends JPanel {

	@Setter
	private Image fundo;

	private HashMap<String, Botao> botoes;

	public Painel() {
		setLayout(null);
		botoes = new HashMap<>();
	}

	public Botao getBotao(String titulo) {
		return botoes.get(titulo);
	}

	public void setBotao(String titulo, Botao botao) {
		botoes.put(titulo, botao);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fundo, 0, 0, this);
	}
}
