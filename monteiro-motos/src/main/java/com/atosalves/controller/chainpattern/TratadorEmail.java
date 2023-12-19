package com.atosalves.controller.chainpattern;

import com.atosalves.controller.exceptions.CredenciaisInvalidasException;
import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.usuario.CadastroDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.dto.usuario.UsuarioDTO;

public class TratadorEmail extends TratadorEtapa{

    @Override
    public void tratarRequisicao(LoginDTO login, UsuarioDTO usuarioDTO) throws CredenciaisInvalidasException {
        if(usuarioDTO == null) throw new CredenciaisInvalidasException("Email invalido");
        if(getProximoTratador() != null){
            getProximoTratador().tratarRequisicao(login, usuarioDTO);
        }
    }

    @Override
    public void tratarRequisicao(CadastroDTO cadastro) throws CredenciaisInvalidasException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (usuarioDAO.recuperarPeloId(cadastro.email()) != null) {
			throw new CredenciaisInvalidasException("Esse email já foi cadastrado");
		}
        if(getProximoTratador() != null){
            getProximoTratador().tratarRequisicao(cadastro);
        }
    }
    
}
