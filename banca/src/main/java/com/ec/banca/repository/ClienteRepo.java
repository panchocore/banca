package com.ec.banca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.banca.model.Cliente;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {

}
