package com.atosalves.model.statepattern;

import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.exceptions.AcessoNegadoException;

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

}
