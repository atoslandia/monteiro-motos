package projeto_poo.erros;

public class CorridaReinvidicadaException extends Exception {
	public String getMessage() {
		return "Corrida reinvidicada";
	}
}
