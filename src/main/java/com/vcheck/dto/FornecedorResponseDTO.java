package com.vcheck.dto;

import com.vcheck.domain.Fornecedor;

public record FornecedorResponseDTO(
        Long id,
        String nome,
        String tipo,
        String empresa
) {
    public FornecedorResponseDTO(Fornecedor dados){
        this(dados.getId(), dados.getNome(),
                dados.getTipo().getTipo(),
                dados.getEmpresa().getNome());
    }
}
