package com.atosalves.dto;

import java.time.LocalDate;

public record CadastroDTO(String nome, String sobrenome, LocalDate dataNascimento, String email, String senha) {}
