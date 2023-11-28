package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;

import lombok.Getter;


@Getter
public abstract class CorridaState {

    private Corrida corrida;
    protected String nome;

    public CorridaState(Corrida corrida){
        this.corrida = corrida;
    }

    public abstract void solicitarCorrida();
	
	public abstract void finalizarCorrida();

	public abstract void reivindicarCorrida();

	public abstract void cancelarCorrida();

}
