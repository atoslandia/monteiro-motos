package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;

public class CorridaEmAndamento implements CorridaState{

     private Corrida corrida;

    public CorridaEmAndamento(Corrida corrida) {
        this.corrida = corrida;
    }
    
}
