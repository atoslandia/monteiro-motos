package projeto_poo.erros;

public class AdministradorNullException extends Exception {
	@Override
	public String getMessage() {
		return "Sem administrador cadastrado";
	}
}
