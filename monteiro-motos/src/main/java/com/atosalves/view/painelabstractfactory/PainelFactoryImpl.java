package com.atosalves.view.painelabstractfactory;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactory;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.inicio.CadastroEditarUsuarioPainel;
import com.atosalves.view.paineis.inicio.LoginPainel;
import com.atosalves.view.paineis.menu.CorridasMenuPainel;
import com.atosalves.view.paineis.menu.EditarMenuPainel;
import com.atosalves.view.paineis.menu.InicioMenuPainel;

public class PainelFactoryImpl implements PainelFactory {

	private ComponentesFactory factory;

	public PainelFactoryImpl(ComponentesFactory factory) {
		this.factory = factory;
	}

	@Override
	public Painel loginPainel() {
		return new LoginPainel(factory).construirPainel();
	}

	@Override
	public Painel cadastroPainel() {
		return new CadastroEditarUsuarioPainel(factory).construirPainel();
	}

	@Override
	public Painel inicioMenuPainel() {
		return new InicioMenuPainel(factory).construirPainel();
	}

	@Override
	public Painel corridasMenuPainel() {
		return new CorridasMenuPainel(factory).construirPainel();
	}

	@Override
	public Painel editarMenuPainel() {
		return new EditarMenuPainel(factory).construirPainel();
	}
}
