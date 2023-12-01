package com.atosalves.controller;

import com.atosalves.dao.CorridaDAO;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.UpdateCorridaDTO;
import com.atosalves.model.Corrida;
import com.atosalves.model.Endereco;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.observerpattern.Observador;

public class GerenciadorDeCorrida implements Observador {
    
    private Corrida corrida;
    private CorridaDAO corridaDAO =  new CorridaDAO();

    public GerenciadorDeCorrida() {
        corrida = new Corrida();
    }

    @Override
    public void update(CorridaEventoDTO corrida) {
        //TODO r: Pegar a corrida pelo id usando o estado antigo dela e mudando de array ultilizando o estado novo
        CorridaDTO corridaDTO = new CorridaDTO(corrida.corrida());
        corridaDAO.update(corridaDTO);
        corridaDAO.moverCorrida(corrida);
    }

    public void solicitarCorrida(Passageiro passageiro, Endereco pontoDeEnconto, Endereco destino){
        if(corrida.getObservador() == null){
            corrida = new Corrida(passageiro, pontoDeEnconto, destino);
            CorridaDTO corridaDTO = new CorridaDTO(corrida);
            corrida.adicionarObservador(this);
            corridaDAO.cadastrar(corridaDTO); 
        }else{
            System.out.println("Cancele a corrida para poder solicitar outra");
        }
        
    }

    public void reivindicarCorrida(Mototaxista mototaxista){
        corrida.reivindicarCorrida(mototaxista);
    }

    public void cancelarCorrida(){
        corrida.cancelarCorrida();
    }

}
