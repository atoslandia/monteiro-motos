package com.atosalves.dao.interfaceDAO;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import java.util.List;

public interface BuscaCorridasDAO {
	List<CorridaDTO> buscarCorridasPendentes();

	List<CorridaDTO> buscarCorridasReinvidicadas();

	List<CorridaDTO> buscarCorridasDoUsuario(String id);

	void moverCorrida(CorridaEventoDTO evento);

	CorridaDTO buscarCorridaReivindicadaMototaxista(String id);
}
