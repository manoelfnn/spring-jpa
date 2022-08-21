package com.example.springjpa.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjpa.dtos.OrdemDto;
import com.example.springjpa.entities.Ordem;
import com.example.springjpa.entities.OrdemItem;
import com.example.springjpa.services.OrdemService;

@RestController
@RequestMapping("/ordens")
public class OrdemController {

	@Autowired
	private OrdemService ordemService;

	@PostMapping
	public OrdemDto criar(@Valid @RequestBody OrdemDto ordemDto) {
		ordemService.criar(ordemDto);
		return ordemDto;
	}

	@GetMapping
	public List<Ordem> listar() {
		return ordemService.listar();
	}

	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		ordemService.remover(id);
	}

	@GetMapping("/{id}/items")
	public List<OrdemItem> listaItens(@PathVariable Long id) {
		return ordemService.listaItens(id);
	}

}
