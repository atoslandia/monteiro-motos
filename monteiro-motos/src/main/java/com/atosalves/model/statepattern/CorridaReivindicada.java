package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;

import lombok.Getter;

public class CorridaReivindicada extends CorridaState{

    public CorridaReivindicada(Corrida corrida) {
        super(corrida);
        nome = "REIVINDICADA";
    }

    @Override
    public void solicitarCorrida() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'acionarCorrida'");
    }

    @Override
    public void finalizarCorrida() {
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
