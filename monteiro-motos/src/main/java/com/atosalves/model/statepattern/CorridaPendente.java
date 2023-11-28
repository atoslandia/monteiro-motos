package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;

import lombok.Getter;

public class CorridaPendente extends CorridaState {

    public CorridaPendente(Corrida corrida) {
        super(corrida);
        nome = "PENDENTE";
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
