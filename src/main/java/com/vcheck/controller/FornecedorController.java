package com.vcheck.controller;

import com.vcheck.dto.*;
import com.vcheck.service.FornecedorService;
import jakarta.transaction.Transactional;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @Transactional
    public ResponseEntity<FornecedorResponseDTO> createSupllier(@RequestBody FornecedorRequestDTO dto) {
        var empresa = this.fornecedorService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping
    public Page<FornecedorResponseDTO> listAll(@ParameterObject
                                               @PageableDefault(
                                                       size = 10, page = 0,
                                                       sort = "nome",
                                                       direction = Sort.Direction.ASC) Pageable pageable) {
        var fornecedores = this.fornecedorService.listAll(pageable);
        return fornecedores;
    }

    @GetMapping("/{idUsuario}")
    public Page<FornecedorResponseDTO> listSuplliers(@PathVariable Long idUsuario, @ParameterObject
    @PageableDefault(
            size = 10, page = 0,
            sort = "nome",
            direction = Sort.Direction.ASC) Pageable pageable) {
        var fornecedores = this.fornecedorService.listSuppliers(idUsuario, pageable);
        return fornecedores;
    }

    @DeleteMapping("/{idFornecedor}")
    @Transactional
    public ResponseEntity deleteSupllier(@PathVariable Long idFornecedor) {
        this.fornecedorService.delete(idFornecedor);
        return ResponseEntity.noContent().build();
    }
}
