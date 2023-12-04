package com.atosalves.model.statepattern;

import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.Estado;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;
import lombok.Getter;

public class CorridaReivindicada extends CorridaState {

	public CorridaReivindicada(Corrida corrida) {
		super(corrida);
		nome = Estado.REINVINDICADA;
	}

	@Override
	public void finalizarCorrida() {
		corrida.setEstado(new CorridaFinalizada(corrida));
	}

	@Override
	public void cancelarCorrida(TipoUsuario tipoUsuario) {
		if (tipoUsuario.equals(TipoUsuario.MOTOTAXISTA)) {
			corrida.setEstado(new CorridaCancelada(corrida));
			corrida.removerObservador();
		} else {
			System.out.println("Usuario nao pode cancelar a corrida");
		}
	}

	@Override
	public void reivindicarCorrida(UsuarioDTO mototaxista) {
		System.out.println("Corrida ja reivindicada");
	}
}
