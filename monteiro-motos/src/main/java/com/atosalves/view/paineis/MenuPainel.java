package com.atosalves.view.paineis;

import com.atosalves.enums.TiposUsuario;
import com.atosalves.view.componentes.*;

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
		construtor.texto("BEM VINDO(A)").construir();

		// TODO se for passageiro
		construtor
			.botao("SOLICITAR CORRIDA", solicitarCorrida)
			.botao("COMPRAR CRÉDITOS", compraCredito)
			.construir();

		// TODO se for mototaxista
		construtor.botao("REINVIDICAR CORRIDA", reinvidicarCorrida).construir();

		// TODO se for adminastro
		construtor
			.botao("LISTAR TODOS OS USUÁRIOS", usuarios)
			.botao("DEFINIR VALOR DE CRÉTIDO DE REINVIDICAÇÃO", valorCredito)
			.botao("DADOS DO CAIXA", caixa)
			.construir();

		construtor
			.botao("LISTAR CORRIDAS", corridas)
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
