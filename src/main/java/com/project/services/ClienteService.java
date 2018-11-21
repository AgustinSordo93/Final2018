package com.project.services;

import java.util.List;

import com.project.entity.Cliente;

public interface ClienteService {

	public List<Cliente> getAll();
	public Cliente getById(Long id);
	public Cliente save(Cliente Cliente);
	public Cliente delete (Long id);
}


