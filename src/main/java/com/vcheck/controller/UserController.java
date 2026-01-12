package com.vcheck.controller;

import com.vcheck.dto.UserRequestDTO;
import com.vcheck.dto.UserResponseDTO;
import com.vcheck.service.UserService;
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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO dto){
        var user = this.userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public Page<UserResponseDTO> listAll(@ParameterObject
                                             @PageableDefault(
                                                     size = 10, page = 0,
                                                     sort = "nome",
                                                     direction = Sort.Direction.ASC) Pageable pageable){
        var users = this.userService.listAll(pageable);

        return users;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findBy(@PathVariable Long id){
        var user = this.userService.findByUser(id);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id){
        this.userService.deleteUser(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
