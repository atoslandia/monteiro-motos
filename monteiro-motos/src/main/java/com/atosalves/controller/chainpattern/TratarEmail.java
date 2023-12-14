package com.atosalves.controller.chainpattern;

import com.atosalves.controller.exceptions.CredenciaisInvalidasException;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.dto.usuario.UsuarioDTO;

public class TratarEmail extends TratadorEtapaLogin{

    @Override
    public void tratarRequisicao(LoginDTO login, UsuarioDTO usuarioDTO) throws CredenciaisInvalidasException {
        if(usuarioDTO == null) throw new CredenciaisInvalidasException("Email invalido");
        if(getProximoTratador() != null){
            getProximoTratador().tratarRequisicao(login, usuarioDTO);
        }
    }
    
}
