package com.atosalves.model;

import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.statepattern.CorridaPendente;
import com.atosalves.model.statepattern.CorridaState;
import com.atosalves.observerpattern.Observavel;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Corrida extends Observavel{

	@Include
	private Long id;

	private CorridaState estado;

	private Mototaxista mototaxista;
	private Passageiro passageiro;
	private final float valor = 5.0f;
	private Endereco pontoDeEncontro;
	private Endereco destino;

	public Corrida(UsuarioDTO passageiro, Endereco pontoDeEncontro, Endereco destino) {
		this.id = System.currentTimeMillis();
		this.passageiro = (Passageiro) passageiro.usuario();
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
		this.estado = new CorridaPendente(this);
	}

	public void setEstado(CorridaState estado){
		String estadoAntigo =  this.estado.getNome();
		this.estado = estado;
		CorridaEventoDTO evento =  new CorridaEventoDTO(estadoAntigo, this);
		notificarObservador(evento);
	}

	public void finalizarCorrida(){
		estado.finalizarCorrida();
	}

	public void reivindicarCorrida(UsuarioDTO mototaxista){

		estado.reivindicarCorrida(mototaxista);
	}

	public void cancelarCorrida(TipoUsuario tipoUsuario){
		estado.cancelarCorrida(tipoUsuario);
	}
}
