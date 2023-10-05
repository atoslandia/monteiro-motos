package com.atosalves.view;

import com.atosalves.view.paineis.PainelPadrao;

public class JanelaPrincipal extends JanelaPadrao {

	public JanelaPrincipal(PainelPadrao primeiroPainel) {
		setTitle("MONTEIRO MOTOS");
		setVisible(true);
		trocaDePainel(primeiroPainel);
	}

	private void trocaDePainel(PainelPadrao painel) {
		getContentPane().removeAll(); // Remove todos os componentes da janela
		getContentPane().add(painel); // Adiciona o novo painel à janela
		revalidate(); // Atualiza a janela
		repaint();
	}
}
