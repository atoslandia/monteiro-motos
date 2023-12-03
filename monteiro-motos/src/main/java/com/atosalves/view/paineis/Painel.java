package com.atosalves.view.paineis;

import com.atosalves.dto.LoginDTO;
import com.atosalves.view.componentes.Botao;
import com.atosalves.view.janelas.JanelaPrincipal;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lombok.Setter;

public class Painel extends JPanel {

	@Setter
	private Image fundo;

	private HashMap<String, Botao> hashBotoes;

	public Painel() {
		setLayout(null);
		hashBotoes = new HashMap<>();
	}

	public Botao getBotao(String titulo) {
		return hashBotoes.get(titulo);
	}

	public void setBotao(String titulo, Botao botao) {
		hashBotoes.put(titulo, botao);
	}

	public void setPainel(Painel painel) {
		var janela = (JanelaPrincipal) SwingUtilities.getWindowAncestor(this);
		janela.setPainel(painel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fundo, 0, 0, this);
	}
}
