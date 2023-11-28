package com.atosalves.observerpattern;

import com.atosalves.dto.CorridaEventoDTO;

public interface Observador {
    void update(CorridaEventoDTO corrida);
}
