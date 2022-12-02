package projeto_poo;

public class Administrador {
	private String nome;
	private String email;
	private String senha;
	private Sexo sexo;
	
	public Administrador(String nome, String email, String senha, Sexo sexo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
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
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "nome: "+nome+" email: "+email+" senha: "+senha+" sexo: "+sexo;
	}

}
