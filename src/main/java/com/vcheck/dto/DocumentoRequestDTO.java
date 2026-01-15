package com.vcheck.dto;

import java.time.LocalDate;

public record DocumentoRequestDTO(
        String tipo,
        LocalDate validade,
        String status,
        String urlArquivo,
        Long idFornecedor
) {
}
