package com.atosalves.model;

import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.exceptions.SaldoInsuficienteExceptions;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passageiro extends Usuario {

	private GerenciadorDePagamento gerenciadorDePagamento;

	public Passageiro() {
		this.gerenciadorDePagamento = new GerenciadorDePagamento(0f);
	}

	public void depositar(float valor) {
		gerenciadorDePagamento.depositar(valor);
	}

	public void pagarCorrida(float valor) throws SaldoInsuficienteExceptions {
		gerenciadorDePagamento.pagarCorrida(valor);
	}

	@Override
	public TipoUsuario getTipo(){
		return TipoUsuario.PASSAGEIRO;
	}

}
