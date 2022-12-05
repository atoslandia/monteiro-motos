package projeto_poo;

import java.time.LocalDate;

public class Administrador extends Pessoas{
	
	public Administrador(String nome, String email, String senha, Sexo sexo, LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	private String nome;
	private String email;
	private String senha;
	private Sexo sexo;
	private LocalDate dataNascimento;
	
	public String getNome() {
		return nome;
	}

	public Sexo getSexo() {
		return sexo;
	}
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String toString() {
		return "nome: "+nome+" email: "+email+" senha: "+senha+" sexo: "+sexo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

}
