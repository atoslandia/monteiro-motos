package com.atosalves.model.statepattern;

import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.Estado;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;
import lombok.Getter;

public class CorridaPendente extends CorridaState {

	public CorridaPendente(Corrida corrida) {
		super(corrida);
		nome = Estado.PENDENTE;
	}

	@Override
	public void finalizarCorrida() {
		System.out.println("Corrida Pendente, não é possivel finalizar");
	}

	@Override
	public void reivindicarCorrida(UsuarioDTO mototaxista) {
		corrida.setMototaxista((Mototaxista) mototaxista.usuario());
		corrida.setEstado(new CorridaReivindicada(corrida));
	}

	@Override
	public void cancelarCorrida(TipoUsuario tipoUsuario) {
		if (tipoUsuario.equals(TipoUsuario.PASSAGEIRO)) {
			corrida.setEstado(new CorridaCancelada(corrida));
			corrida.removerObservador();
		} else {
			System.out.println("Mototaxista nao pode cancelar corrida");
		}
	}
}
