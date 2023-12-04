package com.atosalves.dto;

import com.atosalves.enums.Estado;
import com.atosalves.model.Corrida;

public record CorridaEventoDTO(Estado estadoAntigo, Corrida corrida) {}
