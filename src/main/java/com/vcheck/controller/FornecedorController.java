package com.vcheck.controller;

import com.vcheck.dto.*;
import com.vcheck.service.FornecedorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    @Transactional
    public ResponseEntity<FornecedorResponseDTO> createEmpresa(@RequestBody FornecedorRequestDTO dto){
        var empresa = this.fornecedorService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }
}
