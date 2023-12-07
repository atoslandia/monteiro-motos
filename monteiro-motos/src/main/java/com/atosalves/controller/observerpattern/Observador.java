package com.atosalves.controller.observerpattern;

import com.atosalves.dto.corrida.CorridaEventoDTO;

public interface Observador {
    void update(CorridaEventoDTO corrida);
}
