package com.vcheck.service;

import com.vcheck.domain.Fornecedor;
import com.vcheck.domain.enumeration.TipoFornecedor;
import com.vcheck.dto.FornecedorRequestDTO;
import com.vcheck.dto.FornecedorResponseDTO;
import com.vcheck.infra.exception.ValidacaoException;
import com.vcheck.repository.EmpresaClienteRepository;
import com.vcheck.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
