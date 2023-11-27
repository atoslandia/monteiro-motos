package com.atosalves.view.painelabstractfactory;

import com.atosalves.view.componentes.componentesafactory.ComponentesFactoryImpl;
import com.atosalves.view.paineis.Painel;
import com.atosalves.view.paineis.depoisdomenu.*;
import com.atosalves.view.paineis.inicio.*;
import com.atosalves.view.paineis.menu.*;

public class PainelFactoryImpl implements PainelFactory {

	private ComponentesFactoryImpl factory;

	public PainelFactoryImpl(ComponentesFactoryImpl factory) {
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

	@Override
	public Painel extratoPainel() {
		return new ExtratoPainel(factory).construirPainel();
	}

	@Override
	public Painel depositarSaldo() {
		return new DepositarSaldo(factory).construirPainel();
	}

	@Override
	public Painel adicionarPainel() {
		return new AdicionarCreditoPainel(factory).construirPainel();
	}
}
