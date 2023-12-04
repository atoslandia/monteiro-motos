package com.atosalves.model.statepattern;

import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import lombok.Getter;

@Getter
public abstract class CorridaState {

	protected Corrida corrida;

	protected EstadoCorrida nome;

	public CorridaState(Corrida corrida) {
		this.corrida = corrida;
	}

	public abstract void finalizarCorrida();

	public abstract void reivindicarCorrida(UsuarioDTO mototaxista);

	public abstract void cancelarCorrida(TipoUsuario tipoUsuario);
}
