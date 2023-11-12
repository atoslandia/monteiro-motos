package com.atosalves.view.paineis;

import com.atosalves.view.builder.ConstrutorPainel;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.janelas.Janela;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lombok.Setter;

// TODO implementar o template method quando for finalizar a estilização
public abstract class PainelPadrao extends JPanel {

	protected ComponentesFactory fabrica;
	protected ConstrutorPainel construtor;

	@Setter
	private Image fundo;

	public PainelPadrao() {
		setLayout(null);

		fabrica = new ComponentesFactory();
		construtor = new ConstrutorPainel(this);
		construirComponentes();
	}

	protected abstract void construirComponentes();

	protected void setPainel(PainelPadrao painel) {
		Janela janela = (Janela) SwingUtilities.getWindowAncestor(this);

		janela.setPainel(painel);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// TODO mudar fundo depois
		g.drawImage(fundo, 0, 0, this);
	}
}
