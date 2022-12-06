package projeto_poo.erros;

public class AdministradroNaoExisteException extends Exception{
	@Override
	public String getMessage() {
		return "Administrador não encontrado";
	}
}
