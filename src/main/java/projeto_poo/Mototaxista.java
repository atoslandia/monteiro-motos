package projeto_poo;

import java.time.LocalDate;

import projeto_poo.erros.SemCreditosException;

public class Mototaxista extends Usuario{
	
	private int creditos;

	public Mototaxista(String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String senha) {
		super(nome, sobrenome, dataNascimento, sexo, email, senha);
	}

	public int getCreditos() throws SemCreditosException {
		if(creditos < 0) {
			creditos = 0;
			throw new SemCreditosException();
		}
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

}
