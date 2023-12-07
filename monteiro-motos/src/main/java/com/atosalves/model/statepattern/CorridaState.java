package com.atosalves.model.statepattern;

import com.atosalves.dto.corrida.CorridaDTO;
import com.atosalves.dto.corrida.EnderecoDTO;
import com.atosalves.dto.usuario.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Avaliacao;
import com.atosalves.model.Corrida;
import com.atosalves.model.exceptions.AcessoNegadoException;
import com.atosalves.model.exceptions.SaldoInsuficienteExceptions;
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

	public abstract CorridaDTO solicitarCorrida(
		UsuarioDTO passageiro,
		EnderecoDTO pontoDeEncontro,
		EnderecoDTO destino
	) throws AcessoNegadoException, SaldoInsuficienteExceptions;

	public abstract void avaliarMototaxista(Avaliacao avaliacao) throws AcessoNegadoException;
}
