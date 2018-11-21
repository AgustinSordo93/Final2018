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

import com.project.entity.Contacto;
import com.project.services.ContactoService;

@RestController
@RequestMapping("/contactos")
public class ContactoController {
	
	@Autowired
	private ContactoService contactoService;
	
	@GetMapping
	public ResponseEntity <?> getAll(){
		ResponseEntity<?> response = null;
		
		try {
			List<Contacto> contacto = this.contactoService.getAll();
			response = ResponseEntity.ok(contacto);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		return response;
		
	}
	@PostMapping
	public ResponseEntity <?> save(@RequestBody Contacto contacto) {
		
		ResponseEntity <?> response =null;
		try {
			Contacto result = this.contactoService.save(contacto);
			response = ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		return response;
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id")long id) {
		ResponseEntity<?> response =null;
		try {
			Contacto contacto= this.contactoService.getById(id);
			
			if(contacto !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(contacto);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
		{}
		return response;
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable("id")Long id){
		
		ResponseEntity<?> response =null;
		try {
			Contacto contacto = this.contactoService.delete(id);
			if(contacto !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(contacto);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
		return response;
	}

}
