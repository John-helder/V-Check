package com.vcheck.dto;

public record EmpresaClienteRequestDTO(
        String nome,
        String cnpj,
        String setor,
        Long  consultorId
) {
}
