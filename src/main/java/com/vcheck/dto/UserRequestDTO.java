package com.vcheck.dto;

public record UserRequestDTO(
        String nome,
        String email,
        String senha,
        String plano
) {
}
