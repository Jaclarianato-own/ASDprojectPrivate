package com.asdproject.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.asdproject.models.Persona;
import com.asdproject.services.PersonaService;

@RestController
@RequestMapping("api/persona")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	@GetMapping("/obtenerPersonas")
	public ResponseEntity<?> obtenerActivosFijos() {
		
		try {
			
			ArrayList<Persona> personas = personaService.getAllPersonas();
			if(null != personaService.error) throw new Exception(personaService.error);	
			
			if(personas.size()<= 0) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			return ResponseEntity.ok(personas);
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}

}
