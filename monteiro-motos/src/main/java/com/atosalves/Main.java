package com.atosalves;

import com.atosalves.view.janelas.JanelaPrincipal;
import com.atosalves.view.paineis.inicio.LoginPainel;

public class Main {

	public static void main(String[] args) {
		new JanelaPrincipal(new LoginPainel());
	}
}
