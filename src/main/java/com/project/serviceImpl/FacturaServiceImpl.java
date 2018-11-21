package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.entity.Factura;
import com.project.services.FacturaService;
import com.project.repository.FacturaRepository;

public class FacturaServiceImpl implements FacturaService {
	@Autowired
	public FacturaRepository facturaRepository;
	
	@Override
	public List<Factura> getAll() {
		// TODO Auto-generated method stub
		return this.facturaRepository.findAll();
	}

	@Override
	public Factura getById(Long id) {
		// TODO Auto-generated method stub
		return this.facturaRepository.findById(id).orElse(null);
	}

	@Override
	public Factura save(Factura factura) {
		// TODO Auto-generated method stub
		return this.facturaRepository.save(factura);
	}

	@Override
	public Factura Delete(Long id) {
		Factura factura = this.getById(id);
		if(factura !=null) {
			this.facturaRepository.delete(factura);
		}
	
		return factura;
	}

	@Override
	public Factura findByLetraAndSucursalAndNumero(String letra, Integer sucursal, Integer numero) {
		Factura factura = this.findByLetraAndSucursalAndNumero(letra, sucursal, numero);
		if(factura !=null) {
			this.findByLetraAndSucursalAndNumero(letra, sucursal, numero);
		}
		
		return factura;
	}
	

}
