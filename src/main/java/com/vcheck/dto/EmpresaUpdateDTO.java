package com.vcheck.dto;

public record EmpresaUpdateDTO(
        Long id,
        String nome,
        String cnpj,
        String setor
) {
}
