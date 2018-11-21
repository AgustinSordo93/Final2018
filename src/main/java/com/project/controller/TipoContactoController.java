package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.TipoContacto;
import com.project.services.TipoContactoService;

@RestController
@RequestMapping("/tipo-contactos")
public class TipoContactoController {

	@Autowired
	private TipoContactoService tipoContactoService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response = null;
		
		try {
			List<TipoContacto> tiposContacto = this.tipoContactoService.getAll();
			response = ResponseEntity.ok(tiposContacto);
		}	catch (Exception e) {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		
		return response;
	}
	
	@PostMapping

	public ResponseEntity<?> save(@RequestBody TipoContacto tipoContacto) {
		
		ResponseEntity<?> response =null;
		try {
			TipoContacto result = this.tipoContactoService.save(tipoContacto);
			response = ResponseEntity.status(HttpStatus.OK).body(result);
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

		}
		return response;
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id")long id) {
		ResponseEntity<?> response =null;
		try {
			TipoContacto tipoContacto = this.tipoContactoService.getById(id);
			
			if(tipoContacto !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(tipoContacto);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
			
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")Long id){
		
		ResponseEntity<?> response =null;
		
		try {
			TipoContacto tipoContacto = this.tipoContactoService.delete(id);
			if(tipoContacto !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(tipoContacto);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
		return response;
	}

}
