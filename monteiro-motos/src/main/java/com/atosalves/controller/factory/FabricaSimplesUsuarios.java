package com.atosalves.controller.factory;

import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;

public class FabricaSimplesUsuarios {
    
    public Usuario criaUsuario(TipoUsuario tipo){
        Usuario usuario = null;

        if(tipo.equals(TipoUsuario.MOTOTAXISTA)){
            usuario = new Mototaxista();
        }else if(tipo.equals(TipoUsuario.PASSAGEIRO)){
            usuario = new Passageiro();
        }
        return usuario;
    }
}
