package projeto_poo.erros;

public class NenhumaCorridaException extends Exception{
	public String getMessage() {
		return "Nenhuma corrida encontrada";
	}
}
