package com.asdproject.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asdproject.models.Area;
import com.asdproject.repositories.AreaRepository;

@Service
public class AreaService {

	public Exception error;

	@Autowired
	AreaRepository areaRepository;
	
	public ArrayList<Area> getAllAreas() {

		error = null;

		try {

			return (ArrayList<Area>) areaRepository.findAll();

		} catch (Exception e) {
			error = e;
			return null;
		}

	}
	
}
