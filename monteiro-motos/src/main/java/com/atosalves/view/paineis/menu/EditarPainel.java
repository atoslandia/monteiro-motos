package com.atosalves.view.paineis.menu;

import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;

public class EditarPainel extends PainelPadrao {

	@Override
	protected void construirComponentes() {
		construtor.texto("TESTE", Tema.FONTE_MUITO_FORTE).construir();
	}

	@Override
	protected void instanciarComponentes() {} //TODO
}
