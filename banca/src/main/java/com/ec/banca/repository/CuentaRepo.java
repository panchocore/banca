package com.ec.banca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ec.banca.model.Cuenta;

@Repository
public interface CuentaRepo extends JpaRepository<Cuenta, Integer>  {
	

}
