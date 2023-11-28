package com.atosalves.controller;

import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.observerpattern.Observador;

public class GerenciadorDeCorrida implements Observador {

    @Override
    public void update(CorridaEventoDTO corrida) {
        //TODO r: Pegar a corrida pelo id usando o estado antigo dela e mudando de array ultilizando o estado novo
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
