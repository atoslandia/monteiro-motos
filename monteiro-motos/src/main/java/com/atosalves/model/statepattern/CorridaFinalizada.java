package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;

import lombok.Data;

@Data
public class CorridaFinalizada implements CorridaState {
    private Corrida corrida;

    public CorridaFinalizada(Corrida corrida) {
        this.corrida = corrida;
    }
    
}
