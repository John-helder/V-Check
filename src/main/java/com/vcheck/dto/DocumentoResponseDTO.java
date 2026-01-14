package com.vcheck.dto;

import com.vcheck.domain.Documento;

import java.time.LocalDate;

public record DocumentoResponseDTO(
        Long id,
        String tipo,
        LocalDate validade,
        String status,
        String urlArquivo,
        String fornecedor
) {
    public DocumentoResponseDTO(Documento documento){
        this(documento.getId(),
                documento.getTipo().getLabel(),
                documento.getDataValidade(),
                documento.getStatus().getStatus(),
                documento.getArquivoUrl(),
                documento.getFornecedor().getNome());
    }
}
