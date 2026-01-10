package com.vcheck.domain;

import com.vcheck.domain.enumeration.Plano;
import com.vcheck.dto.UserRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private Plano plano;
    private Boolean ativo;

    public User(UserRequestDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();
        this.plano = Plano.fromString(dto.plano());
        this.ativo = Boolean.TRUE;
    }
}
