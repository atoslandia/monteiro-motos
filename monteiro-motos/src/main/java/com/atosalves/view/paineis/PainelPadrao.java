package com.atosalves.view.paineis;

import com.atosalves.view.builder.ConstrutorPainel;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.janelas.JanelaPrincipal;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// TODO implementar o template method quando for finalizar a estilização
public abstract class PainelPadrao extends JPanel {

	// TODO apagar depois
	private GridLayout layout;

	protected ComponentesFactory fabrica;
	protected ConstrutorPainel construtor;

	public PainelPadrao() {
		layout = new GridLayout(0, 2, 5, 5);
		fabrica = new ComponentesFactory();
		construtor = new ConstrutorPainel(this);
		setLayout(layout);
		instanciarComponentes();
		construirComponentes();
	}

	protected void proximoPainel(PainelPadrao painel) {
		JanelaPrincipal janela = (JanelaPrincipal) SwingUtilities.getWindowAncestor(
			this
		);

		janela.setPainel(painel);
	}

	protected abstract void construirComponentes();

	protected abstract void instanciarComponentes();
}
