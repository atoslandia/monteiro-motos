package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;

public class CorridaEmAndamento extends CorridaState{

    public CorridaEmAndamento(Corrida corrida) {
        super(corrida);
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
