package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;

import lombok.Getter;


public class CorridaCancelada  extends CorridaState{

    public CorridaCancelada(Corrida corrida) {
        super(corrida);
        nome = "CANCELADA";
    }

    @Override
    public void solicitarCorrida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'solicitarCorrida'");
    }

    @Override
    public void finalizarCorrida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finalizarCorrida'");
    }

    @Override
    public void reivindicarCorrida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reivindicarCorrida'");
    }

    @Override
    public void cancelarCorrida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarCorrida'");
    }  
    
}
