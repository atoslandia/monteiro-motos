package com.atosalves.view.paineis;

import com.atosalves.view.builder.ConstrutorPainel;
import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.janelas.JanelaPrincipal;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// TODO implementar o template method quando for finalizar a estilização
public abstract class PainelPadrao extends JPanel {

	ComponentesFactory fabrica;
	ConstrutorPainel construtor;

	public PainelPadrao() {
		setLayout(null);

		fabrica = new ComponentesFactory();
		construtor = new ConstrutorPainel(this);
		instanciarComponentes();
		construirComponentes();
	}

	void setPainel(PainelPadrao painel) {
		JanelaPrincipal janela = (JanelaPrincipal) SwingUtilities.getWindowAncestor(
			this
		);

		janela.setPainel(painel);
	}

	abstract void construirComponentes();

	abstract void instanciarComponentes();

	@Override
	protected void paintComponent(Graphics g) {
		var imagemDeFundo = new ImageIcon(
			"C:\\Users\\Atos\\Desktop\\projetos faculdade\\2projetopp\\monteiro-motos-remake\\monteiro-motos\\src\\main\\resources\\fundo-padrao.png"
		)
			.getImage();
		super.paintComponent(g);
		g.drawImage(imagemDeFundo, 0, 0, this);
	}
}
