package com.example.springjpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.springjpa.dtos.ClienteDto;
import com.example.springjpa.entities.Cliente;
import com.example.springjpa.entities.Ordem;
import com.example.springjpa.repositories.ClienteRepository;
import com.example.springjpa.repositories.OrdemRepository;

@Service
public class ClienteService {

	private ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente criar(ClienteDto clienteDto) {
		Cliente cliente = clienteDto.criarCliente();
		return clienteRepository.save(cliente);
	}

	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	public Boolean remover(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			return false;
		}
		clienteRepository.delete(cliente.get());
		return true;
	}

	public Cliente atualizar(Long id, ClienteDto clienteDto) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			return null;
		}
		cliente.get().setNome(clienteDto.getNome());
		cliente.get().setTelefone(clienteDto.getTelefone());
		cliente.get().setEndereco(clienteDto.getEndereco());
		return clienteRepository.save(cliente.get());
	}

	public List<Ordem> listaOrdens(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (!cliente.isPresent()) {
			return null;
		}
		return cliente.get().getOrdens();
	}

}
