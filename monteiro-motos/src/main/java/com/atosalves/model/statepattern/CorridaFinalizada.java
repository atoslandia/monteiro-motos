package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;


public class CorridaFinalizada extends CorridaState {


    public CorridaFinalizada(Corrida corrida) {
        super(corrida);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void acionarCorrida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'acionarCorrida'");
    }

    @Override
    public void aceitarCorrida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aceitarCorrida'");
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