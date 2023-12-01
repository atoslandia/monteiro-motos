package com.atosalves.dto;

import com.atosalves.enums.TipoUsuario;

public record LoginDTO(String email, String senha, TipoUsuario tipoUsuario) {}
