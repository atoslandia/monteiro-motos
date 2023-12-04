package com.atosalves.model.statepattern;

import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.Estado;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;
import lombok.Getter;

public class CorridaCancelada extends CorridaState {

	public CorridaCancelada(Corrida corrida) {
		super(corrida);
		nome = Estado.CANCELADA;
	}

	@Override
	public void finalizarCorrida() {
		// TODO Auto-generated method stub
		System.out.println("Corrida Cancelada");
	}

	@Override
	public void cancelarCorrida(TipoUsuario tipoUsuario) {
		// TODO Auto-generated method stub
		System.out.println("Corrida Cancelada");
	}

	@Override
	public void reivindicarCorrida(UsuarioDTO mototaxista) {
		// TODO Auto-generated method stub
		System.out.println("Corrida Cancelada");
	}
}
