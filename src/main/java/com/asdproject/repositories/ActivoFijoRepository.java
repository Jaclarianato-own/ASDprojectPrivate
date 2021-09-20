package com.asdproject.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.asdproject.models.ActivoFijo;


public interface ActivoFijoRepository extends CrudRepository<ActivoFijo, String>{
	
	@Query("select e from ActivoFijo e where year(e.fechaCompra) = ?1 and month(e.fechaCompra) = ?2 and day(e.fechaCompra) = ?3")
	public ArrayList<ActivoFijo> getByFechaCompra(int year, int month, int day);
	
	@Query("select e from ActivoFijo e where e.tipo =?1")
	public ArrayList<ActivoFijo> getByTipo(String tipo);
	
	@Query("select e from ActivoFijo e where e.serial =?1")
	public ArrayList<ActivoFijo> getBySerial(String serial);

	

}
