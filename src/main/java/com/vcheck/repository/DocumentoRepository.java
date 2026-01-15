package com.vcheck.repository;

import com.vcheck.domain.Documento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DocumentoRepository extends CrudRepository<Documento, Long> {

    Page<Documento> findByAtivoTrue(Pageable pageable);
}
