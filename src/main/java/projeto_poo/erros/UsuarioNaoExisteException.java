package projeto_poo.erros;

public class UsuarioNaoExisteException extends Exception{
	public String getMessage() {
		return "Não existe esse usuário";
	}
}
