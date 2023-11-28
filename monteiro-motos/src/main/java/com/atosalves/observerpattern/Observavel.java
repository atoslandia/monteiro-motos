package com.atosalves.observerpattern;

import com.atosalves.dto.CorridaEventoDTO;

public abstract class Observavel {
    private Observador observador;

    public void adicionarObservador(Observador observador){
        this.observador = observador;
    }
    public void removerObservador(){
        observador = null;
    }

    protected void notificarObservador(CorridaEventoDTO corrida){
        observador.update(corrida);
    }


}
