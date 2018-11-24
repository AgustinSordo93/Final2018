package com.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.TipoContacto;
import com.project.repository.TipoContactoRepository;
import com.project.services.TipoContactoService;
@Service
public class TipoContactoServiceImpl implements TipoContactoService{
	
	@Autowired
	private TipoContactoRepository tipoContactoRepository;

	@Override
	public List<TipoContacto> getAll() {
		// TODO Auto-generated method stub
		return this.tipoContactoRepository.findAll();
	}

	@Override
	public TipoContacto getById(Long id) {
		// TODO Auto-generated method stub
		return this.tipoContactoRepository.findById(id).orElse(null);
	}

	@Override
	public TipoContacto save(TipoContacto tipoContacto) {
		// TODO Auto-generated method stub
		return this.tipoContactoRepository.save(tipoContacto);
	}

	@Override
	public TipoContacto delete(Long id) {
		// TODO Auto-generated method stub
		TipoContacto tipoContacto = this.getById(id);
		if (tipoContacto !=null) {

		this.tipoContactoRepository.delete(tipoContacto);	
		}

		return tipoContacto;
	}

}
