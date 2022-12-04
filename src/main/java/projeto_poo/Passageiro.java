package projeto_poo;

import java.time.LocalDate;

public class Passageiro {

	public Passageiro(String n,Sexo s,LocalDate dn,String e) {
		nome = n;
		sexo = s;
		dataNascimento = dn;
		email = e;
	
	}
	private String nome;
	private Sexo sexo;
	private LocalDate dataNascimento;
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return getNome();
	}
}
