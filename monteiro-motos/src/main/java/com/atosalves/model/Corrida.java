package com.atosalves.model;

import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.model.statepattern.CorridaPendente;
import com.atosalves.model.statepattern.CorridaState;
import com.atosalves.observerpattern.Observavel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Corrida extends Observavel{

	@Include
	private Long id;

	private CorridaState estado;

	private Mototaxista mototaxista;
	private Passageiro passageiro;
	private float valor;
	private Endereco pontoDeEncontro;
	private Endereco destino;

	public Corrida(Passageiro passageiro, Endereco pontoDeEncontro, Endereco destino) {
		this.id = System.currentTimeMillis();
		this.passageiro = passageiro;
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
		this.estado = new CorridaPendente(this);
	}

	public void setEstado(CorridaState estado){
		String estadoAntigo =  this.estado.getNome();
		this.estado = estado;
		CorridaEventoDTO evento =  new CorridaEventoDTO(estadoAntigo, this);
		notificarObservador(evento);
	}

	public void finalizarCorrida(){
		estado.finalizarCorrida();
	}

	public void reivindicarCorrida(Mototaxista mototaxista){
		estado.reivindicarCorrida(mototaxista);
	}

	public void cancelarCorrida(){
		estado.cancelarCorrida();
	}
}
