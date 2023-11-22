package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;

public abstract class CorridaState {

    private Corrida corrida;

    public CorridaState(Corrida corrida){
        this.corrida = corrida;
    }

    public abstract void acionarCorrida();
	
	public abstract void aceitarCorrida();

	public abstract void reivindicarCorrida();

	public abstract void cancelarCorrida();

}
