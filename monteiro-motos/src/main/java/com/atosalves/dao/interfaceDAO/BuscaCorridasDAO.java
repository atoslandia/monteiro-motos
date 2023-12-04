package com.atosalves.dao.interfaceDAO;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.model.Corrida;
import java.util.List;

public interface BuscaCorridasDAO {
	public List<CorridaDTO> buscarCorridasPendentes();

	public List<CorridaDTO> buscarCorridasEmAndamento();

	public List<CorridaDTO> buscarCorridasCanceladas();

	public List<CorridaDTO> buscarCorridasFinalizadas();

	List<CorridaDTO> buscarCorridasDoUsuario(String id);

	public void moverCorrida(CorridaEventoDTO evento);

	public CorridaDTO buscarUmaCorridaDoUsuario(String id, EstadoCorrida estado);
}
