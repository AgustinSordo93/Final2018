package com.project.services;

import java.util.List;

import com.project.entity.Factura;

public interface FacturaService {
	
	public List<Factura> getAll();
	public Factura getById(Long id);
	public Factura save(Factura factura);
	public Factura Delete (Long id);
	public Factura findByLetraAndSucursalAndNumero(String letra, Integer sucursal, Integer numero);
}
