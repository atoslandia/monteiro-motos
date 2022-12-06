package projeto_poo.erros;

public class MenorDeIdadeException extends Exception{
	public String getMessage() {
		return "permitido apenas maiores de 18 anos";
	}
}
