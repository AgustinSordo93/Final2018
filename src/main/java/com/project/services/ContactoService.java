package com.project.services;

import java.util.List;

import com.project.entity.Contacto;

public interface ContactoService {
	
	public List<Contacto> getAll();
	public Contacto getById(Long id);
	public Contacto save(Contacto Contacto);
	public Contacto delete (Long id);

}



