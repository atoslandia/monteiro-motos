package com.atosalves.view;

import com.atosalves.view.janelas.JanelaPrincipal;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.inicio.LoginPainel;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Painel painelInicial = new LoginPainel().criarPainel();
			new JanelaPrincipal(painelInicial);
		});
	}
}
