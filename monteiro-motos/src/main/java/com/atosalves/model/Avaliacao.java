package com.atosalves.model;

import com.atosalves.dto.UsuarioDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Avaliacao {

    public Avaliacao(UsuarioDTO passageiro, int estrelas) {
        this.passageiro = (Passageiro) passageiro.usuario();
        this.estrelas = estrelas;
    }
    private Passageiro passageiro;
    private int estrelas;

}
