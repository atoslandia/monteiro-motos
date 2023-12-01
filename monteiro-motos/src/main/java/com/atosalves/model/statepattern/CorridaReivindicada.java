package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;

import lombok.Getter;

public class CorridaReivindicada extends CorridaState{

    public CorridaReivindicada(Corrida corrida) {
        super(corrida);
        nome = "REIVINDICADA";
    }

    @Override
    public void finalizarCorrida() {
       corrida.setEstado(new CorridaFinalizada(corrida));
    }


    @Override
    public void cancelarCorrida() {
        corrida.setEstado(new CorridaCancelada(corrida));
        corrida.removerObservador();
    }

    @Override
    public void reivindicarCorrida(Mototaxista mototaxista) {
        System.out.println("Corrida ja reivindicada");
    }
    


}
