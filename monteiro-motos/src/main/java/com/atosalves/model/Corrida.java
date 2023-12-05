package com.atosalves.model;

import com.atosalves.dto.CorridaDTO;
import com.atosalves.dto.CorridaEventoDTO;
import com.atosalves.dto.EnderecoDTO;
import com.atosalves.dto.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.exceptions.AcessoNegadoException;
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
public class Corrida extends Observavel {

	@Include
	private Long id;

	private CorridaState estado;

	private Mototaxista mototaxista;
	private Passageiro passageiro;
	private final float valor = 5.0f;
	private Endereco pontoDeEncontro;
	private Endereco destino;

	public Corrida(UsuarioDTO passageiro, EnderecoDTO pontoDeEncontro, EnderecoDTO destino) {
		this.id = System.currentTimeMillis();
		this.passageiro = (Passageiro) passageiro.usuario();
		this.pontoDeEncontro = pontoDeEncontro.endereco();
		this.destino = destino.endereco();
		this.estado = new CorridaPendente(this);
	}

	public void setEstado(CorridaState estado) {
		EstadoCorrida estadoAntigo = this.estado.getNome();
		this.estado = estado;
		CorridaEventoDTO evento = new CorridaEventoDTO(estadoAntigo, this);
		notificarObservador(evento);
	}

	public void finalizarCorrida() throws AcessoNegadoException {
		estado.finalizarCorrida();
	}

	public void reivindicarCorrida(UsuarioDTO mototaxista) throws AcessoNegadoException {
		estado.reivindicarCorrida(mototaxista);
	}

	public void cancelarCorrida(TipoUsuario tipoUsuario) throws AcessoNegadoException {
		estado.cancelarCorrida(tipoUsuario);
	}

	public CorridaDTO solicitarCorrida(UsuarioDTO passageiro, EnderecoDTO pontoDeEncontro, EnderecoDTO destino)
		throws AcessoNegadoException {
		return estado.solicitarCorrida(passageiro, pontoDeEncontro, destino);
	}
}
