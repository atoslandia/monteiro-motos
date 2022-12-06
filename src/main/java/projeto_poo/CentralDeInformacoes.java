package projeto_poo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import projeto_poo.erros.MenorDeIdadeException;
import projeto_poo.erros.UsuarioNaoExisteException;

public class CentralDeInformacoes {
	
	private ArrayList<Usuario> todosOsUsuarios = new ArrayList<Usuario>();
	private ArrayList<Corrida> todasAsCorridas = new ArrayList<Corrida>();
	
	public ArrayList<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}
	public void setTodosOsPassageiros(ArrayList<Usuario> todosOsUsuarios) {
		this.todosOsUsuarios = todosOsUsuarios;
	}
	public ArrayList<Corrida> getTodasAsCorridas() {
		return todasAsCorridas;
	}
	public void setTodasAsCorridas(ArrayList<Corrida> todasAsCorridas) {
		this.todasAsCorridas = todasAsCorridas;
	}
	
	public void adicionarUsuario(Usuario usuario) throws MenorDeIdadeException {
		try {
			recuperarUsuarioPeloEmail(usuario.getEmail());
			LocalDate dataAtual = LocalDate.now();
		    Period periodo = Period.between(usuario.getDataNascimento(), dataAtual);
			if(periodo.getYears() < 18)
				throw new MenorDeIdadeException();
		} catch (Exception e) {
				todosOsUsuarios.add(usuario);
		}
	}
	
	public boolean adicionarCorrida(Corrida corrida) {
		if(recuperarCorridaPeloId(corrida.getId()) == null)
				return false;
		return getTodasAsCorridas().add(recuperarCorridaPeloId(corrida.getId()));
	}
	
	public Usuario recuperarUsuarioPeloEmail(String email) throws UsuarioNaoExisteException {
		for(Usuario i: todosOsUsuarios) {
			if(i.getEmail().equals(email))
				return i;
		}
		
		throw new UsuarioNaoExisteException();
	}
	
	public Corrida recuperarCorridaPeloId(long id) {
		for(Corrida c: getTodasAsCorridas()) {
			if(c.getId() == id)
				return c;
		}
		return null;
	}
	
	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email) throws Exception{
		
		ArrayList<Corrida> corridasRecuperadas = new ArrayList<Corrida>();
		
		for(Corrida c: getTodasAsCorridas())
			if(c.getPassageiro().getEmail().equals(email))
				corridasRecuperadas.add(c);
		return corridasRecuperadas;
	}
	
	
}