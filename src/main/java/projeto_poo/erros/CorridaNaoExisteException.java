package projeto_poo.erros;

public class CorridaNaoExisteException extends Exception{
	public String getMessage() {
		return "Corrida não existente";
	}
}
