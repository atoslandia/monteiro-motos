package com.atosalves.dto.corrida;

import com.atosalves.enums.EstadoCorrida;
import com.atosalves.model.Corrida;

public record CorridaEventoDTO(EstadoCorrida estadoAntigo, Corrida corrida) {}
