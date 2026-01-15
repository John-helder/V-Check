package com.vcheck.repository;


import com.vcheck.domain.Fornecedor;
import com.vcheck.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
    Boolean existsByEmail(String email);

    Page<User> findByAtivoTrue(Pageable pageable);
}
