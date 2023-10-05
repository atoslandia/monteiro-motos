package com.atosalves.view.paineis;

import com.atosalves.view.JanelaPrincipal;
import com.atosalves.view.abstractfactory.ComponentesFactory;
import com.atosalves.view.builder.ConstrutorPainel;
import java.awt.GridLayout;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;

public abstract class PainelPadrao extends JPanel {

	private GridLayout layout;
	protected ComponentesFactory fabrica;
	protected ConstrutorPainel construtor;

	@Getter
	@Setter
	private JanelaPrincipal janela;

	public PainelPadrao() {
		this.janela = janela;
		layout = new GridLayout(0, 2, 5, 5);
		fabrica = new ComponentesFactory();
		construtor = new ConstrutorPainel(this);
		setLayout(layout);
	}

	protected abstract void construirComponentes();

	public void adicionarProximoPainel(PainelPadrao painel) {
		// Remove o painel atual
		janela.getContentPane().remove(this);

		// Adiciona o novo painel à janela
		janela.getContentPane().add(painel);

		// Atualiza a janela
		janela.getContentPane().validate();
		janela.getContentPane().repaint();
	}
}
