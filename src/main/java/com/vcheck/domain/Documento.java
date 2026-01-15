package com.vcheck.domain;

import com.vcheck.domain.enumeration.StatusDocumento;
import com.vcheck.domain.enumeration.TipoDocumento;
import com.vcheck.dto.DocumentoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "documentos")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoDocumento tipo;

    private LocalDate dataValidade;

    @Enumerated(EnumType.STRING)
    private StatusDocumento status;

    private String arquivoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Fornecedor fornecedor;

    private Boolean ativo = true;

    public Documento(DocumentoRequestDTO dto) {
        this.tipo = TipoDocumento.fromString(dto.tipo());
        this.dataValidade = dto.validade();
        this.status = StatusDocumento.fromString(dto.status());
        this.arquivoUrl = dto.urlArquivo();

    }
}
