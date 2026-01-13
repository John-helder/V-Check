package com.vcheck.controller;

import com.vcheck.dto.EmpresaClienteRequestDTO;
import com.vcheck.dto.EmpresaClienteResponseDTO;
import com.vcheck.dto.EmpresaUpdateDTO;
import com.vcheck.service.EmpresaClienteService;
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
@RequestMapping("/empresa")
public class EmpresaClienteController {

    @Autowired
    private EmpresaClienteService service;

    @PostMapping
    @Transactional
    public ResponseEntity<EmpresaClienteResponseDTO> createEmpresa(@RequestBody EmpresaClienteRequestDTO dto){
        var empresa = this.service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresa);
    }

    @GetMapping
    public Page<EmpresaClienteResponseDTO> getAllEmpresa(@ParameterObject
                                                         @PageableDefault(
                                                             size = 10, page = 0,
                                                             sort = "nome",
                                                             direction = Sort.Direction.ASC) Pageable pageable){

        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaClienteResponseDTO> findByEmpresa(@PathVariable Long id){

        var empresa = service.getbyEmpresa(id);

        return ResponseEntity.ok().body(empresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<EmpresaClienteResponseDTO> toAlter(@RequestBody EmpresaUpdateDTO dto){

        var empresa = service.toAlter(dto);

        return ResponseEntity.ok().body(empresa);
    }
}
