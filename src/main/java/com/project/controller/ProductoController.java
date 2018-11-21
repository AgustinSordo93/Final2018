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

import com.project.entity.Producto;
import com.project.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> response = null;
		
		try {
			List<Producto> producto = this.productoService.getAll();
			response = ResponseEntity.ok(producto);
		}	catch (Exception e) {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
		
		
		return response;
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Producto producto) {
		
		ResponseEntity<?> response =null;
		try {
			Producto result = this.productoService.save(producto);
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
			Producto producto = this.productoService.getById(id);
			
			if(producto !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(producto);
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
			Producto producto = this.productoService.delete(id);
			if(producto !=null) {
				response = ResponseEntity.status(HttpStatus.OK).body(producto);
			} else {
				response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("404 Error");
			}
		}	catch(Exception e){
			response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage()); 
	}
		return response;
	}

}
