package projeto_poo.erros;

public class CorridaExistenteException extends Exception{
	public String getMessage() {
		return "Corrida já existente";
	}
}
