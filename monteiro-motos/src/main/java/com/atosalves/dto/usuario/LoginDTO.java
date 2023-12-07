package com.atosalves.dto.usuario;

import com.atosalves.enums.TipoUsuario;

public record LoginDTO(String email, String senha, TipoUsuario tipoUsuario) {}
