package com.atosalves.model.statepattern;

import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoTransacao;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Corrida;
import com.atosalves.model.Mototaxista;
import lombok.Getter;

public class CorridaFinalizada extends CorridaState {

	public CorridaFinalizada(Corrida corrida) {
		super(corrida);
		nome = EstadoCorrida.FINALIZADA;
	}

	@Override
	public void finalizarCorrida() {
		System.out.println("Corrida ja foi finalizada");
	}

	@Override
	public void cancelarCorrida(TipoUsuario tipoUsuario) {
		System.out.println("Corrida ja foi finalizada");
	}

	@Override
	public void reivindicarCorrida(UsuarioDTO mototaxista) {
		System.out.println("Corrida ja foi finalizada");
	}
}
