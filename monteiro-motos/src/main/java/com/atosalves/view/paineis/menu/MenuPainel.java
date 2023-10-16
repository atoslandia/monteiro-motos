package com.atosalves.view.paineis.menu;

import com.atosalves.view.componentes.*;
import com.atosalves.view.paineis.PainelInterno;
import com.atosalves.view.paineis.PainelPadrao;
import com.atosalves.view.paineis.inicio.LoginPainel;
import com.atosalves.view.util.Tema;

public class MenuPainel extends PainelPadrao {

	private PainelInterno painel;

	private Botao inicio;
	private Botao corridas;
	private Botao editar;
	private Botao sair;

	public MenuPainel() {
		inicio.setBounds(0, 300, 200, 80);
		inicio.setFont(Tema.FONTE_MUITO_FORTE);
		inicio.setForeground(Tema.AMARELO);
		inicio.setBackground(Tema.PRETO);
		inicio.setLarguraCurva(0);
		inicio.setAlturaCurva(0);

		corridas.setFont(Tema.FONTE_MUITO_FORTE);
		corridas.setBounds(199, 300, 345, 80);
		corridas.setForeground(Tema.AMARELO);
		corridas.setBackground(Tema.PRETO);
		corridas.setLarguraCurva(0);
		corridas.setAlturaCurva(0);

		editar.setFont(Tema.FONTE_MUITO_FORTE);
		editar.setBounds(543, 300, 210, 80);
		editar.setForeground(Tema.AMARELO);
		editar.setBackground(Tema.PRETO);
		editar.setLarguraCurva(0);
		editar.setAlturaCurva(0);

		sair.setLocation(650, 10);

		inicio();
		corridas();
		editar();
		sair();
	}

	private void inicio() {
		inicio.aoClicar(() -> {
			painel.getExibirPainel().show(painel, "INICIO");
		});
	}

	private void corridas() {
		corridas.aoClicar(() -> {
			painel.getExibirPainel().show(painel, "CORRIDAS");
		});
	}

	private void editar() {
		editar.aoClicar(() -> {
			painel.getExibirPainel().show(painel, "EDITAR");
		});
	}

	private void sair() {
		sair.aoClicar(() -> setPainel(new LoginPainel()));
	}

	@Override
	protected void construirComponentes() {
		// TODO r: buscar usuario
		construtor
			.texto("BEM VINDO(A)", Tema.FONTE_MUITO_FORTE)
			.painel(painel)
			.botao("INICIO", inicio)
			.botao("CORRIDAS", corridas)
			.botao("EDITAR", editar)
			.botao("SAIR", sair)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		painel = new MenuPainelInterno();

		this.corridas = fabrica.criarBotao();
		this.inicio = fabrica.criarBotao();
		this.editar = fabrica.criarBotao();
		this.sair = fabrica.criarBotao();
	}
}
