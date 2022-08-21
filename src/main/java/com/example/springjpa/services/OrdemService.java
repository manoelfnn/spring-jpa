package com.example.springjpa.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.stereotype.Service;

import com.example.springjpa.dtos.OrdemDto;
import com.example.springjpa.entities.Ordem;
import com.example.springjpa.entities.OrdemItem;
import com.example.springjpa.repositories.ClienteRepository;
import com.example.springjpa.repositories.OrdemRepository;

@Service
public class OrdemService {

	private OrdemRepository ordemRepository;
	private ClienteRepository clienteRepository;

	public OrdemService(OrdemRepository ordemRepository, ClienteRepository clienteRepository) {
		this.ordemRepository = ordemRepository;
		this.clienteRepository = clienteRepository;
	}

	public Ordem criar(OrdemDto ordemDto) {
		Ordem ordem = ordemDto.criarOrdem(clienteRepository);
		return ordemRepository.save(ordem);
	}
  
	public List<Ordem> listar() {
		return ordemRepository.findAll();
	}

	public Boolean remover(Long id) {
		Optional<Ordem> ordem = ordemRepository.findById(id);
		if (!ordem.isPresent()) {
			return false;
		}
		ordemRepository.delete(ordem.get());
		return true;
	}

	public List<OrdemItem> listaItens(Long id) {
		Optional<Ordem> ordem = ordemRepository.findById(id);
		if (!ordem.isPresent()) {
			return null;
		}
		return ordem.get().getItems();
	}

}
