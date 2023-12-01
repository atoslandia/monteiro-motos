package com.atosalves.controller;

import com.atosalves.dao.CorridaDAO;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.UpdateCorridaDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.model.Corrida;
import com.atosalves.model.Endereco;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;
import com.atosalves.observerpattern.Observador;

public class GerenciadorDeCorrida implements Observador {
    
    private Corrida corrida;
    private CorridaDAO corridaDAO =  new CorridaDAO();
    private UsuarioDAO usuarioDAO =  new UsuarioDAO();

    public GerenciadorDeCorrida() {
        corrida = new Corrida();
    }

    @Override
    public void update(CorridaEventoDTO corrida) {
        CorridaDTO corridaDTO = new CorridaDTO(corrida.corrida());
        corridaDAO.update(corridaDTO);
        corridaDAO.moverCorrida(corrida);
    }

    public void solicitarCorrida(String email, Endereco pontoDeEnconto, Endereco destino){
        UsuarioDTO passageiro = usuarioDAO.recuperarPeloId(email);
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

    public void finalizarCorrida(){
        corrida.finalizarCorrida();
        corrida.getPassageiro().pagarCorrida(corrida.getValor());
    }


}
