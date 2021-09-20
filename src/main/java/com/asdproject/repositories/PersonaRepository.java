package com.asdproject.repositories;

import org.springframework.data.repository.CrudRepository;
import com.asdproject.models.Persona;

public interface PersonaRepository extends CrudRepository<Persona, String> {

}
