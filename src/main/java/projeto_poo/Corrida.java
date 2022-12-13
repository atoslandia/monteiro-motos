package projeto_poo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

import projeto_poo.erros.CorridaEmEsperaException;
import projeto_poo.erros.CorridaReinvidicadaException;

public class Corrida {
	private Mototaxista mototaxistaBloqueado;
	private long id;
	private PontoDeEncontro pontoDeEncontro;
	private Destino destino;
	private Passageiro passageiro;
	
	private LocalDate agendamento;
	
	private String estadoDaCorrida;

	public Corrida(PontoDeEncontro pontoDeEncontro, Destino destino, Passageiro passageiro) {
		this.id = LocalDate.now().toEpochSecond(LocalTime.now(), ZoneOffset.UTC);
		this.agendamento = LocalDate.ofEpochDay(id);
		this.pontoDeEncontro = pontoDeEncontro;
		this.destino = destino;
		this.passageiro = passageiro;
	}
	
//	public String dataDaCorrida() {
//		Date data = new Date(id);
//		int mes = data.getMonth();
//		int ano = data.getYear();
//		return dia+"/"+mes+1+"/"+ano;
//	}
	
	public Passageiro getPassageiro() {
		return passageiro;
	}
	
	public long getId() {
		return id;
	}
	
	public Destino getDestino() {
		return destino;
	}
	public LocalDate getAgendamento() {
		return agendamento;
	}

	public String toString() {
		if(passageiro.getSexo().equals(Sexo.FEMININO))
			return passageiro.getNome()+" pede para pega-la em "+ pontoDeEncontro.getEndereco();
		return passageiro.getNome()+" pede para pega-lo em "+ pontoDeEncontro.getEndereco();
	}


	
	public Mototaxista getMototaxistaBloqueado() {
		return mototaxistaBloqueado;
	}

	public void setMototaxistaBloqueado(Mototaxista mototaxistaBloqueado) {
		this.mototaxistaBloqueado = mototaxistaBloqueado;
	}
	
	public String getEstadoDaCorrida() throws CorridaReinvidicadaException {
		if(estadoDaCorrida.equals("Reinvidicada"))
			throw new CorridaReinvidicadaException();
		return estadoDaCorrida;
	}

	public void setEstadoDaCorrida(String estadoDaCorrida) {
		this.estadoDaCorrida = estadoDaCorrida;
	}

	public void setAgendamento(LocalDate agendamento) {
		this.agendamento = agendamento;
	}
	
}
