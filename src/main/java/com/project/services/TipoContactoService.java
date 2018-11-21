package com.project.services;

import java.util.List;

import com.project.entity.TipoContacto;

public interface TipoContactoService {
	
	public List<TipoContacto> getAll();
	public TipoContacto getById(Long id);
	public TipoContacto save(TipoContacto tipoContacto);
	public TipoContacto delete (Long id);

}
