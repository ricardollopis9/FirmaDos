package com.sv.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sv.modelos.Empresa;

@Repository
public interface InterfaceEmpresa extends CrudRepository<Empresa, Integer> {
	
}

