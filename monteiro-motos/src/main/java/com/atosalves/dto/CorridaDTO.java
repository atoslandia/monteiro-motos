package com.atosalves.dto;

import com.atosalves.model.Corrida;

public record CorridaDTO(Corrida corrida) {
	@Override
	public String toString() {
		return (
			"id: " +
			corrida.getId() +
			"\n" +
			corrida.getPassageiro() +
			"\n" +
			corrida.getPontoDeEncontro() +
			"\n" +
			corrida.getDestino()
		);
	}
}
