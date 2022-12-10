package projeto_poo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import projeto_poo.erros.AdministradroNaoExisteException;
import projeto_poo.erros.CorridaExistenteException;
import projeto_poo.erros.CorridaNaoExisteException;
import projeto_poo.erros.MenorDeIdadeException;
import projeto_poo.erros.NenhumaCorridaException;
import projeto_poo.erros.UsuarioNaoExisteException;

public class CentralDeInformacoes {
	
	private ArrayList<Usuario> todosOsUsuarios = new ArrayList<Usuario>();
	private ArrayList<Corrida> todasAsCorridas = new ArrayList<Corrida>();
	
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
	
	public void adicionarCorrida(Corrida corrida) throws CorridaExistenteException {
		try {
			recuperarCorridaPeloId(corrida.getId());
			throw new CorridaExistenteException();
		} catch (CorridaNaoExisteException e) {
			todasAsCorridas.add(corrida);
			e.printStackTrace();
		}
	}
	
	public void verificarAdm() throws AdministradroNaoExisteException{
		boolean contemAdm = false;
		for(Usuario a: todosOsUsuarios) {
			if(a instanceof Administrador)
				contemAdm = true;
		}
		if(!contemAdm)
			throw new AdministradroNaoExisteException();
	}
	
	public Usuario recuperarUsuarioPeloEmail(String email) throws UsuarioNaoExisteException {
		for(Usuario i: todosOsUsuarios) {
					if(i.getEmail().equals(email))
						return i;
		}
		throw new UsuarioNaoExisteException();
	}
	
	public Corrida recuperarCorridaPeloId(long id) throws CorridaNaoExisteException {
		for(Corrida c: todasAsCorridas) {
			if(c.getId() == id)
				return c;
		}
		throw new CorridaNaoExisteException();
	}
	
	public ArrayList<Corrida> recuperarCorridasDeUmPassageiro(String email) throws NenhumaCorridaException {
		ArrayList<Corrida> corridasRecuperadas = new ArrayList<Corrida>();
		for(Corrida c: todasAsCorridas)
			if(c.getPassageiro().getEmail().equals(email))
				corridasRecuperadas.add(c);
		if(corridasRecuperadas.size() == 0)
			throw new NenhumaCorridaException();
		return corridasRecuperadas;
	}
	
	public ArrayList<Usuario> getTodosOsUsuarios() {
		return todosOsUsuarios;
	}
	public ArrayList<Corrida> getTodasAsCorridas() {
		return todasAsCorridas;
	}
	
}