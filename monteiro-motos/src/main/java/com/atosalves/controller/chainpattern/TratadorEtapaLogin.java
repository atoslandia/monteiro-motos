package com.atosalves.controller.chainpattern;

import com.atosalves.controller.exceptions.CredenciaisInvalidasException;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.dto.usuario.UsuarioDTO;

public abstract class TratadorEtapaLogin {
    protected TratadorEtapaLogin proximoTratador;

    public abstract void tratarRequisicao(LoginDTO login, UsuarioDTO usuarioDTO) throws CredenciaisInvalidasException;

    public TratadorEtapaLogin getProximoTratador() {
        return proximoTratador;
    }

    public void setProximoTratador(TratadorEtapaLogin proximoTratador) {
        this.proximoTratador = proximoTratador;
    }
}
