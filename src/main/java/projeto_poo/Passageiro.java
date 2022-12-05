package projeto_poo;

import java.time.LocalDate;

public class Passageiro extends Pessoas{

	public Passageiro(String nome, String email, String senha, Sexo sexo, LocalDate dataNascimento) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}
	
	private String nome;
	private Sexo sexo;
	private LocalDate dataNascimento;
	private String email;
	
	public String getNome() {
		return nome;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return getNome();
	}
}
