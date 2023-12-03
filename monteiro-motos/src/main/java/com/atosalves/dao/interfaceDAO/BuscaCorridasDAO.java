package com.atosalves.dao.interfaceDAO;

import java.util.List;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.model.Corrida;

public interface BuscaCorridasDAO {


    public List<CorridaDTO> buscarCorridasPendenetes();

    public List<CorridaDTO> buscarCorridasEmAndamento();

    public List<CorridaDTO> buscarCorridasCanceladas();

    public List<CorridaDTO> buscarCorridasFinalizadas();

    List<CorridaDTO> buscarCorridasDoUsuario(String id);

    public void moverCorrida(CorridaEventoDTO evento);

    public CorridaDTO buscarUmaCorridaDoUsuario(String id, String estado);


}
