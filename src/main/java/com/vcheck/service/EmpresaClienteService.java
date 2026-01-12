package com.vcheck.service;

import com.vcheck.domain.EmpresaCliente;
import com.vcheck.dto.EmpresaClienteRequestDTO;
import com.vcheck.dto.EmpresaClienteResponseDTO;
import com.vcheck.dto.EmpresaUpdateDTO;
import com.vcheck.infra.exception.ValidacaoException;
import com.vcheck.repository.EmpresaClienteRepository;
import com.vcheck.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmpresaClienteService {

    @Autowired
    private EmpresaClienteRepository repository;
    @Autowired
    private UserRepository userRepository;

    public EmpresaClienteResponseDTO create(EmpresaClienteRequestDTO dto){

        if(this.repository.existsByCnpj(dto.cnpj()))
            throw new RuntimeException("CNPJ já cadastrado em nossa base de dados.");

        var user = userRepository.findById(dto.consultorId()).orElseThrow(() -> new ValidacaoException("Consultor não identificado"));

        EmpresaCliente empresa = new EmpresaCliente(dto);
        empresa.setConsultor(user);

        var empresaCadastrada = repository.save(empresa);
        return new EmpresaClienteResponseDTO(empresaCadastrada);

    }

    public Page<EmpresaClienteResponseDTO> getAll(Pageable pageable) {

        return repository.findAll(pageable).map(EmpresaClienteResponseDTO::new);
    }

    public EmpresaClienteResponseDTO getbyEmpresa(Long id) {

        var empresa = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Identificador não encontrado."));

        return new EmpresaClienteResponseDTO(empresa);
    }

    public void delete(Long id) {
        var empresa = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Identificador não encontrado."));

        repository.delete(empresa);
    }

    public EmpresaClienteResponseDTO toAlter(EmpresaUpdateDTO dto) {
        var empresa = repository.findById(dto.id()).orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada."));

        if(dto.cnpj() != null){
            if(repository.existsByCnpj(dto.cnpj()))
                throw new ValidacaoException("CNPJ informado já está cadastrado.");

            empresa.setCnpj(dto.cnpj());
        }

        if (dto.nome()!= null)
            empresa.setNome(dto.nome());

        if (dto.setor() != null)
            empresa.setSetor(dto.setor());

        return new EmpresaClienteResponseDTO(empresa);

    }

}
