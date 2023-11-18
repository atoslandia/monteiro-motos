package com.atosalves.model;

import com.atosalves.model.statepattern.CorridaState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Corrida {

	@Include
	private Long id;

	private CorridaState estado;
	private Mototaxista mototaxista;
	private Passageiro passageiro;
	private Endereco endereco;

	public Corrida(Mototaxista mototaxista, Passageiro passageiro, Endereco endereco, CorridaState estado) {
		this.id = System.currentTimeMillis();
		this.estado = estado;
		this.mototaxista = mototaxista;
		this.passageiro = passageiro;
		this.endereco = endereco;
	}
}
