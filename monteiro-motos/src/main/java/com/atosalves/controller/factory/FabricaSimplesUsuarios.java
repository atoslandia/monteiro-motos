package com.atosalves.controller.factory;

import com.atosalves.enums.TiposUsuario;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;

public class FabricaSimplesUsuarios {
    
    public Usuario criaUsuario(TiposUsuario tipo){

        if(tipo.equals(TiposUsuario.MOTOTAXISTA)){
            Mototaxista moto = new Mototaxista();
            return moto;
        }
        Passageiro passageiro = new Passageiro();
        return passageiro;
    }
}
