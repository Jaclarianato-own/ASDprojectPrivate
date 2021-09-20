package com.asdproject.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asdproject.models.Area;
import com.asdproject.services.AreaService;

@RestController
@RequestMapping("api/area")
public class AreaController {

	@Autowired
	AreaService areaService;
	
	@GetMapping("/obtenerAreas")
	public ResponseEntity<?> obtenerActivosFijos() {
		
		try {
			
			ArrayList<Area> areas = areaService.getAllAreas();
			if(null != areaService.error) throw new Exception(areaService.error);	
			
			if(areas.size()<= 0) ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
			return ResponseEntity.ok(areas);
			
		}catch(Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}
	
}
