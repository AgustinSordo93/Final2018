package com.project.serviceImpl;

import java.util.List;

import com.project.entity.Contacto;
import com.project.repository.ContactoRepository;
import com.project.services.ContactoService;

public class ContactoServiceImpl implements ContactoService {
	
	private ContactoRepository contactoRepository;

	@Override
	public List<Contacto> getAll() {
		// TODO Auto-generated method stub
		return this.contactoRepository.findAll();
	}

	@Override
	public Contacto getById(Long id) {
		// TODO Auto-generated method stub
		return this.contactoRepository.findById(id).orElse(null);
	}

	@Override
	public Contacto save(Contacto Contacto) {
		// TODO Auto-generated method stub
		return this.contactoRepository.save(Contacto);
	}

	@Override
	public Contacto delete(Long id) {
		Contacto contacto = this.getById(id);
		if(contacto != null) {
			this.contactoRepository.delete(contacto);
		}
		return contacto;
	}
}

