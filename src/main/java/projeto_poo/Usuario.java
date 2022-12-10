package projeto_poo;

import java.time.LocalDate;

public abstract class Usuario {
	
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String email;
	private String senha;
	private Sexo sexo;
	
	public Usuario(String nome, String sobrenome, LocalDate dataNascimento, Sexo sexo, String email, String senha) {
		setNome(nome);
		setSobrenome(sobrenome);
		setDataNascimento(dataNascimento);
		setSexo(sexo);
		setEmail(email);
		setSenha(senha);
	}
	
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
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String toString() {
		return "<html>"+"Nome: "+nome+" "+sobrenome+"<br><br>"+"Email: "+email+"<br><br>"+"Senha: "+senha+"<br><br>"+"Sexo: "+sexo+"<br><br>"+"Tipo de conta: "+this.getClass().getSimpleName()+"</html>";
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	
}
