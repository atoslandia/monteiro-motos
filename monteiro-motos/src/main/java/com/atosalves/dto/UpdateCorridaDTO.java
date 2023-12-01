package com.atosalves.dto;

import com.atosalves.model.Mototaxista;
import com.atosalves.model.statepattern.CorridaState;

public record UpdateCorridaDTO(CorridaState estado, Mototaxista mototaxista) {
    
}
