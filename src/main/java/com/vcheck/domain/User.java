package com.vcheck.domain;

import com.vcheck.domain.enumeration.Plano;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private Plano plano;
    @Enumerated(EnumType.STRING)
    private Boolean ativo;

}
