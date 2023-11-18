package com.atosalves.dto;

import com.atosalves.enums.TiposUsuario;

public record LoginDTO(String email, String senha, TiposUsuario tiposUsuario) {}
