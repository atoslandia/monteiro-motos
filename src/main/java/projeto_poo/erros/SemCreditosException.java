package projeto_poo.erros;

public class SemCreditosException extends Exception {
	public String getMessage() {
		return "Sem créditos de reinvidicação";
	}
}
