package com.vcheck.domain;

import com.vcheck.dto.EmpresaClienteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "empresas")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpresaCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cnpj;
    private String setor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consultor_id", nullable = false)
    private User consultor;

    public EmpresaCliente(EmpresaClienteRequestDTO dto) {
        this.cnpj = dto.cnpj();
        this.nome = dto.nome();
        this.setor = dto.setor();
    }
}
