package com.atosalves.model.statepattern;

import com.atosalves.dto.corrida.CorridaDTO;
import com.atosalves.dto.corrida.EnderecoDTO;
import com.atosalves.dto.usuario.LoginDTO;
import com.atosalves.dto.usuario.UsuarioDTO;
import com.atosalves.enums.EstadoCorrida;
import com.atosalves.enums.TipoUsuario;
import com.atosalves.model.Avaliacao;
import com.atosalves.model.Corrida;
import com.atosalves.model.exceptions.AcessoNegadoException;
import com.atosalves.model.exceptions.SaldoInsuficienteExceptions;

public class CorridaCancelada extends CorridaState {

	public CorridaCancelada(Corrida corrida) {
		super(corrida);
		nome = EstadoCorrida.CANCELADA;
	}

	@Override
	public void finalizarCorrida() throws AcessoNegadoException {
		throw new AcessoNegadoException("Não foi possivel finalizar");
	}

	@Override
	public void cancelarCorrida(TipoUsuario tipoUsuario) throws AcessoNegadoException {
		throw new AcessoNegadoException("Não foi possivel cancelar");
	}

	@Override
	public void reivindicarCorrida(UsuarioDTO mototaxista) throws AcessoNegadoException {
		throw new AcessoNegadoException("Não foi possivel reivindicar");
	}

	@Override
	public CorridaDTO solicitarCorrida(UsuarioDTO passageiro, EnderecoDTO pontoDeEncontro, EnderecoDTO destino)
		throws SaldoInsuficienteExceptions {
		corrida = new Corrida(passageiro, pontoDeEncontro, destino);
		return new CorridaDTO(corrida);
	}

	@Override
	public void avaliarMototaxista(Avaliacao avaliacao) throws AcessoNegadoException {
		throw new AcessoNegadoException("Não é possivel avaliar");
	}
}
