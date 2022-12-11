package projeto_poo;

import java.time.LocalDate;

public class Mototaxista extends Usuario{
	
	private int creditos;

	public Mototaxista(String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String senha) {
		super(nome, sobrenome, dataNascimento, sexo, email, senha);
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

}
