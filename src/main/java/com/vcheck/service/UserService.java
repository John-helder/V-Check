package com.vcheck.service;

import com.vcheck.domain.EmpresaCliente;
import com.vcheck.domain.User;
import com.vcheck.dto.*;
import com.vcheck.infra.exception.ValidacaoException;
import com.vcheck.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO create(UserRequestDTO dto){

        if(this.userRepository.existsByEmail(dto.email()))
            throw new RuntimeException("E-mail já cadastrado em nossa base de dados.");

        var user = new User(dto);

        var usuarioCadastrado = userRepository.save(user);

        return new UserResponseDTO(usuarioCadastrado);

    }
}
