package com.atosalves.dto.usuario;

import com.atosalves.enums.TipoUsuario;
import java.time.LocalDate;

public record CadastroDTO(String nome, String email, String senha, LocalDate dataNascimento, TipoUsuario tipo) {}
