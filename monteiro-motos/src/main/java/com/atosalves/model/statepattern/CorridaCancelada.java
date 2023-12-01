package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;

import lombok.Getter;


public class CorridaCancelada  extends CorridaState{

    public CorridaCancelada(Corrida corrida) {
        super(corrida);
        nome = "CANCELADA";
    }


    @Override
    public void finalizarCorrida() {
        // TODO Auto-generated method stub
        System.out.println("Corrida Cancelada");
    }


    @Override
    public void cancelarCorrida() {
        // TODO Auto-generated method stub
        System.out.println("Corrida Cancelada");
    }


    @Override
    public void reivindicarCorrida(Mototaxista mototaxista) {
        // TODO Auto-generated method stub
        System.out.println("Corrida Cancelada");
    }  
    
}