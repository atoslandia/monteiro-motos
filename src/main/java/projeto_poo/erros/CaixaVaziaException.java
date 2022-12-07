package projeto_poo.erros;

public class CaixaVaziaException extends Exception{
	public String getMessage() {
		return "O campo está vazio";
	}
}
