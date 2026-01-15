package com.vcheck.service;

import com.vcheck.domain.Fornecedor;
import com.vcheck.domain.enumeration.TipoFornecedor;
import com.vcheck.dto.FornecedorRequestDTO;
import com.vcheck.dto.FornecedorResponseDTO;
import com.vcheck.infra.exception.ValidacaoException;
import com.vcheck.repository.EmpresaClienteRepository;
import com.vcheck.repository.FornecedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private EmpresaClienteRepository empresaRepository;

    public FornecedorResponseDTO create(FornecedorRequestDTO dto) {
        var empresa = empresaRepository.findById(dto.empresaId()).orElseThrow(() -> new ValidacaoException("Empresa não encontrada."));
        Fornecedor fornecedor = new Fornecedor(dto);
        fornecedor.setEmpresa(empresa);

        var novoFornecedor = fornecedorRepository.save(fornecedor);
        return new FornecedorResponseDTO(novoFornecedor);
    }

    public Page<FornecedorResponseDTO> listAll(Pageable pageable) {

        return this.fornecedorRepository.findByAtivoTrue(pageable).map(FornecedorResponseDTO::new);
    }

    public void delete(Long idFornecedor) {
        var supplier = this.fornecedorRepository.findById(idFornecedor).orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado."));

        supplier.setAtivo(false);
    }

    public Page<FornecedorResponseDTO> listSuppliers(Long idUsuario, Pageable pageable) {

        return this.fornecedorRepository.listarForncedoresDoUsuario(idUsuario,pageable).map(FornecedorResponseDTO::new);
    }
}
