package com.atosalves.view.paineis;

import com.atosalves.view.builder.ConstrutorPainel;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.janelas.JanelaPrincipal;
import com.atosalves.view.util.Tema;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// TODO implementar o template method quando for finalizar a estilização
public abstract class PainelPadrao extends JPanel {

	protected ComponentesFactory fabrica;
	protected ConstrutorPainel construtor;

	public PainelPadrao() {
		setLayout(null);

		fabrica = new ComponentesFactory();
		construtor = new ConstrutorPainel(this);
		instanciarComponentes();
		construirComponentes();
	}

	protected void setPainel(PainelPadrao painel) {
		JanelaPrincipal janela = (JanelaPrincipal) SwingUtilities.getWindowAncestor(
			this
		);

		janela.setPainel(painel);
	}

	protected abstract void construirComponentes();

	protected abstract void instanciarComponentes();

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Tema.IMAGE_DE_FUNDO, 0, 0, this);
	}
}
