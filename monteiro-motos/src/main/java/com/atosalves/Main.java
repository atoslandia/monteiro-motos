package com.atosalves;

import com.atosalves.view.janelas.Janela;
import com.atosalves.view.paineis.inicio.LoginPainel;

public class Main {

	public static void main(String[] args) {
		new Janela(new LoginPainel());
	}
}
