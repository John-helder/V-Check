package com.vcheck.service;

import com.vcheck.domain.Documento;
import com.vcheck.dto.DocumentoRequestDTO;
import com.vcheck.dto.DocumentoResponseDTO;
import com.vcheck.infra.exception.ValidacaoException;
import com.vcheck.repository.DocumentoRepository;
import com.vcheck.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {
    @Autowired
    private DocumentoRepository documentoRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public DocumentoResponseDTO create(DocumentoRequestDTO dto) {

        var fornecedor = fornecedorRepository.findById(dto.idFornecedor()).orElseThrow(() -> new ValidacaoException("Identificador do Fornecedor é inválido."));

        Documento documento = new Documento(dto);
        documento.setFornecedor(fornecedor);

        var newDocumento = documentoRepository.save(documento);

        return new DocumentoResponseDTO(newDocumento);
    }

    public Page<DocumentoResponseDTO> listAll(Pageable pageable) {

        return documentoRepository.findByAtivoTrue(pageable).map(DocumentoResponseDTO::new);
    }

    public DocumentoResponseDTO findByDocumento(Long id) {
        var documento = documentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado."));

        return new DocumentoResponseDTO(documento);
    }
}
