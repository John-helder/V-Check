package com.vcheck.domain;

import com.vcheck.domain.enumeration.TipoFornecedor;
import com.vcheck.dto.FornecedorRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "fornecedores")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoFornecedor tipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private EmpresaCliente empresa;

    public Fornecedor(FornecedorRequestDTO dto) {
        this.nome = dto.nome();
        this.tipo = TipoFornecedor.fromString(dto.tipo());
    }
}
