package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.entity.Producto;
import com.project.repository.ProductoRepository;

import com.project.services.ProductoService;

public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	public ProductoRepository prodcutoRepository;
	
	@Override
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return this.prodcutoRepository.findAll();
	}

	@Override
	public Producto getById(Long id) {
		// TODO Auto-generated method stub
		return this.prodcutoRepository.findById(id).orElse(null);
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return this.prodcutoRepository.save(producto);
	}

	@Override
	public Producto delete(Long id) {
		Producto producto = this.getById(id);
		if(producto !=null) {
			this.prodcutoRepository.delete(producto);
		}
		
		return producto;
	}
	
	
}
