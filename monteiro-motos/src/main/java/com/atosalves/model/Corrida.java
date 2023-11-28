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

	public Corrida(Mototaxista mototaxista, Passageiro passageiro, Endereco pontoDeEncontro, Endereco destino) {
		this.id = System.currentTimeMillis();
		this.estado = new CorridaPendente(this);
		this.mototaxista = mototaxista;
		this.passageiro = passageiro;
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
	}

	public void setEstado(CorridaState estado){
		String estadoAntigo =  this.estado.getNome();
		this.estado = estado;
		String estadoNovo =  this.estado.getNome();
		CorridaEventoDTO evento =  new CorridaEventoDTO(id, estadoAntigo, estadoNovo);
		notificarObservador(evento);
	}

	public void solicitarCorrida(){
		estado.solicitarCorrida();
	}

	public void finalizarCorrida(){
		estado.finalizarCorrida();
	}

	public void reivindicarCorrida(){
		estado.reivindicarCorrida();
	}

	public void cancelarCorrida(){
		estado.cancelarCorrida();
	}



}
