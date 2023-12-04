package com.atosalves.dto;

import com.atosalves.enums.EstadoCorrida;
import com.atosalves.model.Corrida;

public record CorridaEventoDTO(EstadoCorrida estadoAntigo, Corrida corrida) {}
