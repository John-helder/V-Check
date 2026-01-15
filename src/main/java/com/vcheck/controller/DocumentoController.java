package com.vcheck.controller;

import com.vcheck.dto.DocumentoRequestDTO;
import com.vcheck.dto.DocumentoResponseDTO;
import com.vcheck.service.DocumentoService;
import jakarta.transaction.Transactional;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    @Autowired
    private DocumentoService service;

    @PostMapping
    @Transactional
    public ResponseEntity<DocumentoResponseDTO> create(@RequestBody DocumentoRequestDTO request, UriComponentsBuilder uriBuilder){
        var documento = service.create(request);

        var uri = uriBuilder.path("/documento/{id}").buildAndExpand(documento.id()).toUri();

        return ResponseEntity.created(uri).body(documento);
    }

    @GetMapping
    public Page<DocumentoResponseDTO> listAll(@ParameterObject
                                                  @PageableDefault(
                                                          size = 10, page = 0,
                                                          sort = "dataValidade",
                                                          direction = Sort.Direction.ASC) Pageable pageable){
        var documentos = service.listAll(pageable);

        return documentos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoResponseDTO> findByDocumento(@PathVariable Long id){
        var documento = service.findByDocumento(id);


        return ResponseEntity.ok().body(documento);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteDocumento(@PathVariable Long id){
        service.deleteDocumento(id);

        return ResponseEntity.noContent().build();
    }
}
