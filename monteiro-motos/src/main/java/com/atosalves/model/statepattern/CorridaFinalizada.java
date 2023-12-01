package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;

import lombok.Getter;

public class CorridaFinalizada extends CorridaState {

    public CorridaFinalizada(Corrida corrida) {
        super(corrida);
        nome = "FINALIZADA";
    }


    @Override
    public void finalizarCorrida() {
        System.out.println("Corrida ja foi finalizada");

    }

    @Override
    public void cancelarCorrida() {
         System.out.println("Corrida ja foi finalizada");
    }


    @Override
    public void reivindicarCorrida(Mototaxista mototaxista) {
         System.out.println("Corrida ja foi finalizada");
    }
    
}
