package projeto_poo.erros;

public class CorridaEmEsperaException extends Exception {
	public String getMessage() {
		return "A corrida está em espera";
	}
}
