package com.atosalves.view.paineis.menu;

import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.LoginPainel;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.util.Tema;

public class MenuPainel extends PainelPadrao {

	private Botao inicio;
	private Botao corridas;
	private Botao editar;
	private Botao sair;

	public MenuPainel() {
		inicio();
		corridas();
		editar();
		sair();
	}

	private void inicio() {
		inicio.aoClicar(() -> setPainel(new InicioPainel()));
		inicio.setFont(Tema.TEXTO_FONTE_MUITO_FORTE);
		inicio.setBounds(0, 300, 200, 80);
	}

	private void corridas() {
		corridas.setFont(Tema.TEXTO_FONTE_MUITO_FORTE);
		corridas.setBounds(203, 300, 350, 80);
		corridas.aoClicar(() -> add(new CorridasPainel()));
	}

	private void editar() {
		editar.setFont(Tema.TEXTO_FONTE_MUITO_FORTE);
		editar.setBounds(555, 300, 200, 80);
		editar.aoClicar(() -> add(new EditarPainel()));
	}

	private void sair() {
		sair.aoClicar(() -> add(new LoginPainel()));
	}

	@Override
	protected void construirComponentes() {
		// TODO r: buscar usuario
		construtor
			.texto("BEM VINDO(A)", Tema.TEXTO_FONTE_MUITO_FORTE)
			.botao("INICIO", inicio)
			.botao("CORRIDAS", corridas)
			.botao("EDITAR", editar)
			.botao("SAIR", sair)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.corridas = fabrica.criarBotao();
		this.inicio = fabrica.criarBotao();
		this.editar = fabrica.criarBotao();
		this.sair = fabrica.criarBotao();
	}
}
