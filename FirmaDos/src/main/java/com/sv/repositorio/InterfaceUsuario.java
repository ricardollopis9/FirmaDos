package com.sv.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sv.modelos.User;

@Repository
public interface InterfaceUsuario extends CrudRepository<User, Integer> {
	
	//@Query(value = "SELECT u.id, u.nombre, u.apellido, u.correo, u.empresa_id FROM user u where u.id = (SELECT e.id from empresa e where e.nombre = ?1)", nativeQuery=true)
	@Query(value = "SELECT u.id, u.nombre, u.apellido, u.correo, u.empresa_id FROM user u where u.empresa_id = ?1", nativeQuery=true)
	public List<User> getUserByEmpresa(Integer empresa_id);
}

