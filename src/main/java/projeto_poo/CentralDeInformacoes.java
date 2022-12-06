package projeto_poo;

import java.util.ArrayList;

public class CentralDeInformacoes {
	
	private Administrador administrador;
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
	
	public Administrador getAdministrador() {
		return administrador;
	}
	
	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}
	
	public boolean adicionarUsuario(Usuario usuario) {
		try {
			recuperarUsuarioPeloEmail(usuario.getEmail());
			
			/* IF(SE É MAIOR DE 18 ANOS)*/
			} catch (Exception e) {
				return false;
		}
		return todosOsUsuarios.add(usuario);
	}
	
	public boolean adicionarCorrida(Corrida corrida) {
		if(recuperarCorridaPeloId(corrida.getId()) == null)
				return false;
		return getTodasAsCorridas().add(recuperarCorridaPeloId(corrida.getId()));
	}
	
	public Usuario recuperarUsuarioPeloEmail(String email) throws Exception {
		for(Usuario i: todosOsUsuarios) {
			if(i.getEmail().equals(email))
				return i;
		}
		throw new Exception();
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