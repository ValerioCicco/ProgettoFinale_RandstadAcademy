package com.example.progettofinalehibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettofinalehibernate.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
