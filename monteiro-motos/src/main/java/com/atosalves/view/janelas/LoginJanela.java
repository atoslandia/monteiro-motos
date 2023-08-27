package com.atosalves.view.janelas;

import com.atosalves.view.JanelaPadrao;
import com.atosalves.view.paineis.LoginPainel;

public class LoginJanela extends JanelaPadrao {

	public LoginJanela() {
		setTitle("Login");
		add(new LoginPainel());
		setVisible(true);
	}
}
