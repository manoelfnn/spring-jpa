package com.example.springjpa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.dtos.ClienteDto;
import com.example.springjpa.entities.Cliente;
import com.example.springjpa.entities.Ordem;
import com.example.springjpa.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ClienteDto criar(@Valid @RequestBody ClienteDto clienteDto) {	
		clienteService.criar(clienteDto);		
		return clienteDto;
	}	

	@GetMapping
	public List<Cliente> listar() {
		return clienteService.listar();
	}
	
	@PutMapping("/{id}")
	public void atualizar(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
		clienteService.atualizar(id, clienteDto);
	}	
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		clienteService.remover(id);
	}
	
	@GetMapping("/{id}/ordens")
	public List<Ordem> listaOrdens(@PathVariable Long id){
		return clienteService.listaOrdens(id);
	}

}
