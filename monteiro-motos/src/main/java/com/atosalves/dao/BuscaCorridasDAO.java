package com.atosalves.dao;

import java.util.List;

import com.atosalves.model.Corrida;

public interface BuscaCorridasDAO {


    public List<Corrida> buscarCorridasPendenetes();

    public List<Corrida> buscarCorridasEmandamento();

    public List<Corrida> buscarCorridasCanceladas();

    public List<Corrida> buscarCorridasReivindicadas();



}
