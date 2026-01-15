package com.vcheck.dto;

import com.vcheck.domain.EmpresaCliente;

public record EmpresaClienteResponseDTO(
        Long id,
        String nome,
        String cnpj,
        String setor,
        Long consultor
) {
    public EmpresaClienteResponseDTO(EmpresaCliente dados){
        this(dados.getId(), dados.getNome(), dados.getCnpj(), dados.getSetor(), dados.getConsultor().getId());
    }
}
