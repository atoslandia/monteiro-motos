package projeto_poo;

import java.time.LocalDate;
import java.util.ArrayList;

public class CentralDeInformacoes {
	
	private Administrador administrador;
	private ArrayList<Passageiro> todosOsPassageiros = new ArrayList<Passageiro>();
	private ArrayList<Corrida> todasAsCorridas = new ArrayList<Corrida>();
	
	public ArrayList<Passageiro> getTodosOsPassageiros() {
		return todosOsPassageiros;
	}
	public void setTodosOsPassageiros(ArrayList<Passageiro> todosOsPassageiros) {
		this.todosOsPassageiros = todosOsPassageiros;
	}
	public ArrayList<Corrida> getTodasAsCorridas() {
		return todasAsCorridas;
	}
	public void setTodasAsCorridas(ArrayList<Corrida> todasAsCorridas) {
		this.todasAsCorridas = todasAsCorridas;
	}
	
	public Administrador getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	public boolean adicionarPassageiro(Passageiro passageiro) {
		if((LocalDate.now().getYear() - passageiro.getDataNascimento().getYear()) < 18)
			return false;
		
		if(passageiro.equals(recuperarPassageiroPeloEmail(passageiro.getEmail())))
			return false;
		return getTodosOsPassageiros().add(passageiro);
	}
	
	public boolean adicionarCorrida(Corrida corrida) {
		if(recuperarCorridaPeloId(corrida.getId()) == null)
				return false;
		return getTodasAsCorridas().add(recuperarCorridaPeloId(corrida.getId()));
	}
	
	public Passageiro recuperarPassageiroPeloEmail(String email) {
		for(Passageiro i: getTodosOsPassageiros()) {
			if(i.getEmail().equals(email))
				return i;
		}
		return null;
	}
	
	public Corrida recuperarCorridaPeloId(long id) {
		for(Corrida c: getTodasAsCorridas()) {
			if(c.getId() == id)
				return c;
		}
		return null;
	}
	
	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email){
		ArrayList<Corrida> corridasRecuperadas = null;
		if(recuperarPassageiroPeloEmail(email) != null)
			corridasRecuperadas = new ArrayList<Corrida>();
		for(Corrida c: getTodasAsCorridas())
			if(c.getPassageiro().getEmail().equals(email))
				corridasRecuperadas.add(c);
		return corridasRecuperadas;
	}
	
	
}