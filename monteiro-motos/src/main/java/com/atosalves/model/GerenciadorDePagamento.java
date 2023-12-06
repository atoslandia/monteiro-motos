package com.atosalves.model;

import com.atosalves.enums.TipoTransacao;
import com.atosalves.model.exceptions.DinheiroInsuficienteExceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GerenciadorDePagamento {

	private float saldo;
	private ArrayList<OperacaoFinanceira> historicoDepositos;
	private ArrayList<OperacaoFinanceira> historicoPagamentos;

	public GerenciadorDePagamento(float saldo) {
		this.saldo = saldo;
		this.historicoDepositos = new ArrayList<>();
		this.historicoPagamentos = new ArrayList<>();
	}

	public void depositar(float valor) {
		LocalDateTime dataDeposito = LocalDateTime.now();
		var deposito = new OperacaoFinanceira(TipoTransacao.DEPOSITO, dataDeposito, valor);
		saldo += valor;
		historicoDepositos.add(deposito);
	}

	public void pagarCorrida(float valor) throws DinheiroInsuficienteExceptions{
		if (valor > saldo) {
			throw new DinheiroInsuficienteExceptions("Faça um deposito.");
		}
		LocalDateTime dataPagamento = LocalDateTime.now();
		var pagamento = new OperacaoFinanceira(TipoTransacao.DEPOSITO, dataPagamento, valor);
		saldo -= valor;
		historicoDepositos.add(pagamento);
	}

}
