package com.atosalves.controller.chainpattern;

import com.atosalves.controller.exceptions.CredenciaisInvalidasException;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.dto.usuario.UsuarioDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.atosalves.model.Usuario;

public class TratarTipo extends TratadorEtapaLogin{

    @Override
    public void tratarRequisicao(LoginDTO login, UsuarioDTO usuarioDTO) throws CredenciaisInvalidasException {
        Usuario usuario = usuarioDTO.usuario();
        if (!login.tipoUsuario().equals(usuario.getTipo())) throw new CredenciaisInvalidasException("Tipo invalido");
        
        if(getProximoTratador() != null){
            getProximoTratador().tratarRequisicao(login, usuarioDTO);
        }
    }
    
}
