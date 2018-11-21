package com.project.services;

import java.util.List;

import com.project.entity.Producto;

public interface ProductoService {
	
	public List<Producto> getAll();
	public Producto getById(Long id);
	public Producto save(Producto producto);
	public Producto delete (Long id);

}
