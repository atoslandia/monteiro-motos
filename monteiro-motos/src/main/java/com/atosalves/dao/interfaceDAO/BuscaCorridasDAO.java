package com.atosalves.dao.interfaceDAO;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.enums.EstadoCorrida;
import java.util.List;

public interface BuscaCorridasDAO {
	List<CorridaDTO> buscarCorridasPendentes();

	List<CorridaDTO> buscarCorridasReinvidicadas();

	List<CorridaDTO> buscarCorridasCanceladas();

	List<CorridaDTO> buscarCorridasFinalizadas();

	List<CorridaDTO> buscarCorridasDoUsuario(String id);

	void moverCorrida(CorridaEventoDTO evento);

	CorridaDTO buscarUmaCorridaDoUsuario(String id, EstadoCorrida estado);

	CorridaDTO buscarCorridaReivindicadaMototaxista(String id);
}
