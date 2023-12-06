package com.atosalves.controller.observerpattern;

import com.atosalves.dto.CorridaEventoDTO;

public interface Observador {
    void update(CorridaEventoDTO corrida);
}
