package com.atosalves.model.statepattern;

import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;

import lombok.Getter;

public class CorridaPendente extends CorridaState {

    public CorridaPendente(Corrida corrida) {
        super(corrida);
        nome = "PENDENTE";
    }

    @Override
    public void finalizarCorrida() {
      System.out.println("Corrida Pendente, não é possivel finalizar" );
    }

    @Override
    public void reivindicarCorrida(Mototaxista mototaxista) {
        corrida.setMototaxista(mototaxista);
        corrida.setEstado(new CorridaReivindicada(corrida));
    }

    @Override
    public void cancelarCorrida() {
        corrida.setEstado(new CorridaCancelada(corrida));
        corrida.removerObservador();
    }





}
