package com.atosalves.view.janelas;

import com.atosalves.view.JanelaPadrao;
import com.atosalves.view.PainelPadrao;
import com.atosalves.view.paineis.LoginPainel;

public class LoginJanela extends JanelaPadrao {

	public LoginJanela() {
		setTitle("Login");
		add();
		setVisible(true);
	}

	public void add() {
		PainelPadrao painel = new LoginPainel();
		add(painel);
	}
}
