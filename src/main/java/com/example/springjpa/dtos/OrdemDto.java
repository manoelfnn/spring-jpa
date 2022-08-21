package com.example.springjpa.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springjpa.entities.Cliente;
import com.example.springjpa.entities.Ordem;
import com.example.springjpa.repositories.ClienteRepository;

public class OrdemDto {
	
	private ClienteRepository clienteRepository;
	
	private LocalDateTime data;
	private Long cliente_id;
	private BigDecimal total;
	
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	
	public Ordem criarOrdem(ClienteRepository clienteRepository) {
		
		Optional<Cliente> cliente = clienteRepository.findById(cliente_id);
		
		if(!cliente.isPresent()) {
			throw new RuntimeException("Cliente não existe");
		}
		
		System.out.println(cliente.get().getNome());
		
		Ordem ordem = new Ordem();
		ordem.setData(data);
		ordem.setCliente(cliente.get());
		ordem.setTotal(total);
				
		return ordem;
	}
}
