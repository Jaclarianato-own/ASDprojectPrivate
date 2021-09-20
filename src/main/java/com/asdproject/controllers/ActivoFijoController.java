package com.asdproject.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.asdproject.models.ActivoFijo;
import com.asdproject.services.ActivoFijoService;


@RestController
@RequestMapping("api/activosFijos")
public class ActivoFijoController {
	
	@Autowired
	ActivoFijoService activoFijoService;	
	
	@GetMapping("/obtenerActivosFijos")
	public ResponseEntity<?> obtenerActivosFijos() {
		
		try {
			
			ArrayList<ActivoFijo> activosFijos = activoFijoService.getAllActivosFijos();
			if(null != activoFijoService.error) throw new Exception(activoFijoService.error);	
			
			if(activosFijos.size()<= 0) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			return ResponseEntity.ok(activosFijos);
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}
	
	@PostMapping("/obtenerActivosFijosPorFecha")
	public ResponseEntity<?> obtenerActivosFijosPorFecha(@RequestBody ActivoFijo activoFijo) {
		
		try {
			
			ArrayList<ActivoFijo> activosFijos = activoFijoService.getByFechaCompra(activoFijo);
			if(null != activoFijoService.error) throw new Exception(activoFijoService.error);
			
			if(activosFijos.size()<= 0) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			return ResponseEntity.ok(activosFijos);
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}

	@PostMapping("/actualizarSerialFechaActivos")
	public ResponseEntity<?> actualizarSerialIntYFechaActivos(@RequestBody ActivoFijo activoFijo) {
		
		try {
			
			boolean esActualizado = activoFijoService.actualizarSerialIntYFechaActivos(activoFijo);
			if(null != activoFijoService.error) throw new Exception(activoFijoService.error);			
			
			return ResponseEntity.ok(esActualizado);
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());			
		}
	}
	
	
	@PostMapping("/crearActivo")
	public ResponseEntity<?> crearActivo(@RequestBody ActivoFijo activoFijo) {

		try {			
			
			boolean esActualizado = activoFijoService.crearActivoFijo(activoFijo);
			if(null != activoFijoService.error) throw new Exception(activoFijoService.error);				
			
			
			return ResponseEntity.ok(esActualizado);
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}
	

}
