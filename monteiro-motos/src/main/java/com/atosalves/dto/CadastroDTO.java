package com.atosalves.dto;

import com.atosalves.enums.TiposUsuario;
import java.time.LocalDate;

public record CadastroDTO(String nome, String email, String senha, LocalDate dataNascimento, TiposUsuario tipo) {}
