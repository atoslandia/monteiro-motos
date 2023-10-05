package com.atosalves;

import com.atosalves.view.JanelaPrincipal;
import com.atosalves.view.paineis.LoginPainel;

public class Main {

	public static void main(String[] args) {
		var j = new JanelaPrincipal(new LoginPainel());
	}
}
