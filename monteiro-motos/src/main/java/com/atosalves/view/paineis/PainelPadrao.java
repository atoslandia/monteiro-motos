package com.atosalves.view.paineis;

import com.atosalves.view.builder.PainelBuilderImpl;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.janelas.JanelaPrincipal;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import lombok.Setter;

// TODO implementar o template method quando for finalizar a estilização
public abstract class PainelPadrao extends JPanel {

	@Setter
	private Image fundo;

	public PainelPadrao() {
		setLayout(null);
		construirComponentes(new ComponentesFactory(), new PainelBuilderImpl(this));
	}

	protected void construirComponentes(ComponentesFactory fabrica, PainelBuilderImpl builder) {
		inicializarComponentes(fabrica);
		montarComponentes(builder);
	}

	protected abstract void inicializarComponentes(ComponentesFactory fabrica);

	protected abstract PainelPadrao montarComponentes(PainelBuilderImpl construtor);

	protected void setPainel(PainelPadrao painel) {
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
