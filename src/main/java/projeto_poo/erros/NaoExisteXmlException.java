package projeto_poo.erros;

public class NaoExisteXmlException extends Exception {
	public String getMessage() {
		return "Não existe arquivo XML, foi criado um novo";
	}
}
