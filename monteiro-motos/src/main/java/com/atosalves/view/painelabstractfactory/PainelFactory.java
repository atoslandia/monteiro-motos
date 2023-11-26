package com.atosalves.view.painelabstractfactory;

import com.atosalves.view.paineis.Painel;

public interface PainelFactory {
	Painel loginPainel();
	Painel cadastroPainel();
	Painel inicioMenuPainel();
	Painel corridasMenuPainel();
	Painel editarMenuPainel();
}
