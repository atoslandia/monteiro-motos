package com.atosalves.model.statepattern;

import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;

public class CorridaCancelada extends CorridaState {

	public CorridaCancelada(Corrida corrida) {
		super(corrida);
		nome = EstadoCorrida.CANCELADA;
	}

	@Override
	public void finalizarCorrida() {
		System.out.println("Corrida Cancelada");
	}

	@Override
	public void cancelarCorrida(TipoUsuario tipoUsuario) {
		System.out.println("Corrida Cancelada");
	}

	@Override
	public void reivindicarCorrida(UsuarioDTO mototaxista) {
		System.out.println("Corrida Cancelada");
	}
}
