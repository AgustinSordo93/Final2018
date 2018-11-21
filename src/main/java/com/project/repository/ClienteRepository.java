package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{ 

}
