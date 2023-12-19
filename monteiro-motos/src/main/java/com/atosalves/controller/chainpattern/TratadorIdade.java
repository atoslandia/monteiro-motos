package com.atosalves.controller.chainpattern;

import java.time.LocalDate;
import java.time.Period;

import com.atosalves.controller.exceptions.CredenciaisInvalidasException;
import com.atosalves.dto.usuario.CadastroDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.dto.usuario.UsuarioDTO;

public class TratadorIdade extends TratadorEtapa {

    @Override
    public void tratarRequisicao(LoginDTO login, UsuarioDTO usuarioDTO) throws CredenciaisInvalidasException {
        throw new UnsupportedOperationException("Metodo não suportado");
    }

    @Override
    public void tratarRequisicao(CadastroDTO cadastro) throws CredenciaisInvalidasException {
        LocalDate dataDeNascimento = cadastro.dataNascimento();
		LocalDate dataAtual = LocalDate.now();
		Period idade = Period.between(dataDeNascimento, dataAtual);
        if (idade.getYears() < 18) {
			throw new CredenciaisInvalidasException("Idade invalida. Permitido acima de 18 anos");
		}
        if(getProximoTratador() != null){
            getProximoTratador().tratarRequisicao(cadastro);
        }
    }
    
}
