package com.atosalves.controller.chainpattern;

import com.atosalves.controller.exceptions.CredenciaisInvalidasException;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.usuario.CadastroDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.dto.usuario.UsuarioDTO;

public abstract class TratadorEtapa {
    protected TratadorEtapa proximoTratador;
    
    public abstract void tratarRequisicao(LoginDTO login, UsuarioDTO usuarioDTO) throws CredenciaisInvalidasException;

    public abstract void tratarRequisicao(CadastroDTO cadastro) throws CredenciaisInvalidasException;
    
    public TratadorEtapa getProximoTratador() {
        return proximoTratador;
    }
    
    public void setProximoTratador(TratadorEtapa proximoTratador) {
        this.proximoTratador = proximoTratador;
    }
}
