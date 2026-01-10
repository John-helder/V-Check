package com.vcheck.controller;

import com.vcheck.dto.FornecedorRequestDTO;
import com.vcheck.dto.FornecedorResponseDTO;
import com.vcheck.dto.UserRequestDTO;
import com.vcheck.dto.UserResponseDTO;
import com.vcheck.repository.UserRepository;
import com.vcheck.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    @Transactional
    public ResponseEntity<UserResponseDTO> createEmpresa(@RequestBody UserRequestDTO dto){
        var user = this.userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
