package com.atosalves.model;

import com.atosalves.dto.usuario.UsuarioDTO;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Avaliacao {
    
    @XStreamAsAttribute
    private Passageiro passageiro;
    private int estrelas;

    public Avaliacao(UsuarioDTO passageiro, int estrelas) {
        this.passageiro = (Passageiro) passageiro.usuario();
        this.estrelas = estrelas;
    }

}
