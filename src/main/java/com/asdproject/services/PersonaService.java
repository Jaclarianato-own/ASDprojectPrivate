package com.asdproject.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asdproject.models.Persona;
import com.asdproject.repositories.PersonaRepository;

@Service
public class PersonaService {

	public Exception error;

	@Autowired
	PersonaRepository personaRepository;
	
	public ArrayList<Persona> getAllPersonas() {

		error = null;

		try {

			return (ArrayList<Persona>) personaRepository.findAll();

		} catch (Exception e) {
			error = e;
			return null;
		}

	}
}
