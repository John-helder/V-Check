package com.vcheck.repository;

import com.vcheck.domain.EmpresaCliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaClienteRepository extends JpaRepository<EmpresaCliente, Long> {

    Boolean existsByCnpj(String cnpj);
}
