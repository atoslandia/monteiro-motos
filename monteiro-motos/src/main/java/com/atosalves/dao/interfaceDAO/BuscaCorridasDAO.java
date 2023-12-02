package com.atosalves.dao.interfaceDAO;

import java.util.List;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.model.Corrida;

public interface BuscaCorridasDAO {


    public List<Corrida> buscarCorridasPendenetes();

    public List<Corrida> buscarCorridasEmAndamento();

    public List<Corrida> buscarCorridasCanceladas();

    public List<Corrida> buscarCorridasFinalizadas();

    public void moverCorrida(CorridaEventoDTO evento);

    public CorridaDTO buscarCorridaDeUmUsuario(String id, String estado);


}
