package projeto_poo;

import java.time.LocalDate;

public class Passageiro extends Usuario{

	public Passageiro(String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String senha) {
		super(nome, sobrenome, dataNascimento, sexo, email, senha);
	}
	
}
