package com.atosalves.model.statepattern;

import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.Estado;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.Endereco;
import com.atosalves.model.Mototaxista;
import com.atosalves.model.Passageiro;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import lombok.Getter;

@Getter
public abstract class CorridaState {

	protected Corrida corrida;

	protected Estado nome;

	public CorridaState(Corrida corrida) {
		this.corrida = corrida;
	}

	public abstract void finalizarCorrida();

	public abstract void reivindicarCorrida(UsuarioDTO mototaxista);

	public abstract void cancelarCorrida(TipoUsuario tipoUsuario);
}
