package com.atosalves.view.main;

import com.atosalves.view.janelas.JanelaPrincipal;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.factorymethod.inicio.LoginPainelCreator;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Painel painelInicial = new LoginPainelCreator().criarPainel();

			new JanelaPrincipal(painelInicial);
		});
	}
}
