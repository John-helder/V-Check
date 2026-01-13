package com.vcheck.repository;

import com.vcheck.domain.Fornecedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    Page<Fornecedor> findByAtivoTrue(Pageable pageable);

    @Query("""
            select f from Fornecedor f 
            join f.empresa e 
            join e.consultor u
            where u.id = :idUsuario
            """)
    Page<Fornecedor> listarForncedoresDoUsuario(Long idUsuario,  Pageable pageable);
}
