package com.example.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springjpa.entities.Ordem;

@Repository
public interface OrdemRepository extends JpaRepository<Ordem, Long> {

	
}
