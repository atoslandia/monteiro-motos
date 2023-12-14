package com.atosalves.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.atosalves.enums.TipoUsuario;

public class Mototaxista extends Usuario {

	private List<Avaliacao> avaliacoes = new ArrayList<>();

	private float lucro;

	public Mototaxista() {}

	public Mototaxista(String nome, LocalDate dataNascimento, String email, String senha) {
		super(nome, dataNascimento, email, senha);
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(Avaliacao avaliacao) {
		avaliacoes.add(avaliacao);
	}

	public float getLucro() {
		return lucro;
	}

	public void setLucro(float lucro) {
		this.lucro = lucro;
	}

	@Override
	public TipoUsuario getTipo(){
		return TipoUsuario.MOTOTAXISTA;
	}

}
