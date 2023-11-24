package com.atosalves.dao.interfaceDAO;

import java.util.List;

import com.atosalves.model.Corrida;

public interface BuscaCorridasDAO {


    public List<Corrida> buscarCorridasPendenetes();

    public List<Corrida> buscarCorridasEmAndamento();

    public List<Corrida> buscarCorridasCanceladas();

    public List<Corrida> buscarCorridasReivindicadas();



}
