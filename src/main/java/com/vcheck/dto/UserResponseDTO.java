package com.vcheck.dto;

import com.vcheck.domain.User;

public record UserResponseDTO(
        Long id,
        String nome,
        String email,
        String plano
) {
    public UserResponseDTO(User dados){
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getPlano().getPlano());
    }
}
