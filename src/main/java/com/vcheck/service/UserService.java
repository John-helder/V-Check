package com.vcheck.service;

import com.vcheck.domain.User;
import com.vcheck.dto.*;
import com.vcheck.infra.exception.ValidacaoException;
import com.vcheck.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<UserResponseDTO> listAll(Pageable pageable) {
        return this.userRepository.findAll(pageable).map(UserResponseDTO::new);
    }

    public UserResponseDTO findByUser(Long id) {
        var user = this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

        return new UserResponseDTO(user);
    }

    public void deleteUser(Long id) {
        var user = this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

        user.setAtivo(false);
    }
}
