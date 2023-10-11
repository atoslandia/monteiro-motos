package com.atosalves.view.paineis;

import com.atosalves.view.componentes.*;
import java.awt.ScrollPane;

public class MenuPainel extends PainelPadrao {

	private Botao solicitarCorrida;
	private Botao compraCredito;
	private Botao corridas;
	private Botao usuarios;
	private Botao reinvidicarCorrida;
	private Botao valorCredito;
	private Botao caixa;
	private Botao editar;
	private Botao sair;

	public MenuPainel() {
		add(new ScrollPane());
		caixa();
		sair();
	}

	private void caixa() {
		caixa.aoClicar(() -> setPainel(new CaixaPainel()));
	}

	private void sair() {
		sair.aoClicar(() -> setPainel(new LoginPainel()));
	}

	@Override
	protected void construirComponentes() {
		// TODO r: buscar usuario
		construtor
			.definirNumComponentes(9)
			.texto("BEM VINDO(A)", true)
			// TODO se for passageiro
			.botao("SOLICITAR CORRIDA", solicitarCorrida)
			.botao("COMPRAR CRÉDITOS", compraCredito)
			// TODO se for mototaxista
			.botao("REINVIDICAR CORRIDA", reinvidicarCorrida)
			// TODO se for adminastro
			.botao("LISTAR TODOS OS USUÁRIOS", usuarios)
			.botao("DEFINIR VALOR DE CRÉTIDO DE REINVIDICAÇÃO", valorCredito)
			.botao("DADOS DO CAIXA", caixa)
			// todos tem
			.botao("CORRIDAS", corridas)
			.botao("EDITAR PERFIL", editar)
			.botao("SAIR", sair)
			.construir();
	}

	@Override
	protected void instanciarComponentes() {
		this.solicitarCorrida = fabrica.criarBotao();
		this.compraCredito = fabrica.criarBotao();
		this.corridas = fabrica.criarBotao();
		this.usuarios = fabrica.criarBotao();
		this.reinvidicarCorrida = fabrica.criarBotao();
		this.valorCredito = fabrica.criarBotao();
		this.caixa = fabrica.criarBotao();
		this.editar = fabrica.criarBotao();
		this.sair = fabrica.criarBotao();
	}
}
