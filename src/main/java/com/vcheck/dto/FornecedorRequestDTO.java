package com.vcheck.dto;

public record FornecedorRequestDTO(
        String nome,
        String tipo,
        Long empresaId
) {
}
