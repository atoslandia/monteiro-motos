package com.atosalves.dao.interfaceDAO;

import com.atosalves.dto.corrida.CorridaDTO;
import com.atosalves.dto.corrida.CorridaEventoDTO;
import com.atosalves.enums.EstadoCorrida;

import java.util.List;

public interface BuscaCorridasDAO {
	List<CorridaDTO> buscarCorridaPeloEstado(EstadoCorrida estadoCorrida);

	List<CorridaDTO> buscarCorridasDoUsuario(String id);

	void moverCorrida(CorridaEventoDTO evento);

	CorridaDTO buscarCorridaReivindicadaMototaxista(String id);
}
