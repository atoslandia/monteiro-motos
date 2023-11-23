package com.atosalves.model;

import com.atosalves.dao.UsuarioDAO;
import com.atosalves.dto.CadastroDTO;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;

	@Include
	private String email;

	private String senha;

	@Getter(AccessLevel.PRIVATE)
	@Setter(AccessLevel.PRIVATE)
	private UsuarioDAO usuarioDAO;

	public Usuario(String nome, String sobrenome, LocalDate dataNascimento, String email, String senha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.senha = senha;
	}
	// public boolean verificarLoginUsuario(LoginDTO data) {
	// 	return usuarioDAO.verificarLogin(data);
	// }

	public void cadastrarUsuario(CadastroDTO data) {
		usuarioDAO.cadastrar(data);
	}
}
