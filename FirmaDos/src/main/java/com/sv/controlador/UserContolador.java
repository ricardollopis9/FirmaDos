package com.sv.controlador;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.modelos.User;
import com.sv.repositorio.InterfaceUsuario;

@RestController
@RequestMapping("/user")
public class UserContolador {
	
	@Autowired
	private InterfaceUsuario interfaceUser;
	
	@GetMapping
	public List<User> usuarios()
	{
		return (List<User>) interfaceUser.findAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody User us)
	{
		interfaceUser.save(us);
	}
	
	@PutMapping 
	public void modificar(@RequestBody User us)
	{
		interfaceUser.save(us);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id)
	{
		interfaceUser.deleteById(id);
	}
	
	@RequestMapping(value="/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		Optional<User> usu = interfaceUser.findById(id);
		return usu.get();
	}
	
	@GetMapping(path = "/empresa/{empresa_id}")
	public List<User> getUserByEmpresa(@PathVariable("empresa_id") Integer empresa_id) {
		
		return interfaceUser.getUserByEmpresa(empresa_id);
		
	}
}
