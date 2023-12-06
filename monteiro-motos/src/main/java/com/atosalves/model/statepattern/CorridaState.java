package com.atosalves.model.statepattern;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.EnderecoDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.exceptions.AcessoNegadoException;
import com.atosalves.model.exceptions.DinheiroInsuficienteExceptions;

import lombok.Getter;

@Getter
public abstract class CorridaState {

	protected Corrida corrida;

	protected EstadoCorrida nome;

	public CorridaState(Corrida corrida) {
		this.corrida = corrida;
	}

	public abstract void finalizarCorrida() throws AcessoNegadoException;

	public abstract void reivindicarCorrida(UsuarioDTO mototaxista) throws AcessoNegadoException;

	public abstract void cancelarCorrida(TipoUsuario tipoUsuario) throws AcessoNegadoException;

	public abstract CorridaDTO solicitarCorrida(UsuarioDTO passageiro, EnderecoDTO pontoDeEncontro, EnderecoDTO destino)
		throws AcessoNegadoException, DinheiroInsuficienteExceptions;
}
