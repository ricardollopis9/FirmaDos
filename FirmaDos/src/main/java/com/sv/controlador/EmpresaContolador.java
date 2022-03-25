package com.sv.controlador;

import java.util.List;
import java.util.Optional;

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

import com.sv.modelos.Empresa;
import com.sv.repositorio.InterfaceEmpresa;

@RestController
@RequestMapping("/empresa")
public class EmpresaContolador {
	
	@Autowired
	private InterfaceEmpresa interfaceEmpresa;
	
	@GetMapping
	public List<Empresa> empresas()
	{
		return (List<Empresa>) interfaceEmpresa.findAll();
	}
	
	@PostMapping
	public void insertar(@RequestBody Empresa em)
	{
		interfaceEmpresa.save(em);
	}
	
	@PutMapping 
	public void modificar(@RequestBody Empresa em)
	{
		interfaceEmpresa.save(em);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id)
	{
		interfaceEmpresa.deleteById(id);
	}
	
	@RequestMapping(value="/{id}")
	public Empresa getUserById(@PathVariable("id") Integer id) {
		Optional<Empresa> usu = interfaceEmpresa.findById(id);
		return usu.get();
	}
}
