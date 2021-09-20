package com.asdproject.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asdproject.models.ActivoFijo;
import com.asdproject.repositories.*;

@Service
public class ActivoFijoService {

	public Exception error;

	@Autowired
	ActivoFijoRepository activoFijoRepository;

	public ArrayList<ActivoFijo> getAllActivosFijos() {

		error = null;

		try {

			return (ArrayList<ActivoFijo>) activoFijoRepository.findAll();

		} catch (Exception e) {
			error = e;
			return null;
		}

	}
	
	public boolean crearActivoFijo(ActivoFijo activoFijo) {

		error = null;

		try {
			
			if(null == activoFijo.getSerial())
				throw new Exception("El campo serial es obligatorio");
			
			if (!activoFijoRepository.findById(activoFijo.getSerial()).isEmpty())
				throw new Exception("El serial "+activoFijo.getSerial()+" ya se encuentra registrado");
			
			if(null != activoFijo.getArea() && null != activoFijo.getPersona())
				throw new Exception("Solamente debe asignar el activo a un área o a una persona");
			
			if(null == activoFijo.getArea() && null == activoFijo.getPersona())
				throw new Exception("Debe asingar el activo fijo a un área o a una persona.");
			
			if(null == activoFijo.getFechaBaja() || null == activoFijo.getFechaCompra())
				throw new Exception("Las fechas no deben ser nulas.");
			
			Calendar calendarFechaBaja = Calendar.getInstance();
			calendarFechaBaja.setTime(activoFijo.getFechaBaja());
			calendarFechaBaja.add(Calendar.HOUR_OF_DAY, 5);
			
			Calendar calendarFechaCompra = Calendar.getInstance();
			calendarFechaCompra.setTime(activoFijo.getFechaCompra());
			calendarFechaCompra.add(Calendar.HOUR_OF_DAY, 5);
			
			if(calendarFechaCompra.before(calendarFechaBaja)) 
				throw new Exception("La fecha de compra no debe ser inferior a la fecha de baja");
			
			activoFijoRepository.save(activoFijo);

			return true;

		} catch (Exception e) {

			error = e;
			return false;
		}
	}

	public boolean actualizarSerialIntYFechaActivos(ActivoFijo activoFijo) {

		error = null;

		try {

			validarEntrada(activoFijo);
			if (null != error)
				throw new Exception(error);

			ActivoFijo activoFijoAux = new ActivoFijo();

			var aux = activoFijoRepository.findById(activoFijo.getSerial());

			if (null != activoFijo.getNumeroInterno()) {
				aux.get().setNumeroInterno(activoFijo.getNumeroInterno());
			}

			if (null != activoFijo.getFechaBaja()) {

				Calendar calendar = Calendar.getInstance();

				calendar.setTime(activoFijo.getFechaBaja());
				calendar.add(Calendar.HOUR_OF_DAY, 5);

				aux.get().setFechaBaja(calendar.getTime());
			}

			activoFijoAux = aux.get();

			activoFijoRepository.save(activoFijoAux);

			return true;

		} catch (Exception e) {

			error = e;
			return false;
		}
	}

	private void validarEntrada(ActivoFijo activoFijo) {

		error = null;

		try {

			if (null != activoFijo.getSerial()) {

				if (null == activoFijo.getNumeroInterno() && null == activoFijo.getFechaBaja())
					throw new Exception(
							"Para continuar se requiere el campo 'numeroInterno' y/o el campo 'fechaBaja'.");

			} else {
				throw new Exception("El campo 'serial' es obligatorio.");
			}

		} catch (Exception e) {

			error = e;

		}

	}

	public ArrayList<ActivoFijo> getByFechaCompra(ActivoFijo activoFijo) {

		error = null;

		try {

			ArrayList<ActivoFijo> activosFijos = new ArrayList<ActivoFijo>();

			if (null != activoFijo.getFechaCompra()) {

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(activoFijo.getFechaCompra());
				calendar.add(Calendar.HOUR_OF_DAY, 5);

				int year = calendar.get(Calendar.YEAR);
				int month = calendar.get(Calendar.MONTH);
				int day = calendar.get(Calendar.DAY_OF_MONTH);

				ArrayList<ActivoFijo> aux = (ArrayList<ActivoFijo>) activoFijoRepository.getByFechaCompra(year, month, day);

				activosFijos.addAll(aux);
			}

			if (null != activoFijo.getTipo()) {

				ArrayList<ActivoFijo> aux = (ArrayList<ActivoFijo>) activoFijoRepository
						.getByTipo(activoFijo.getTipo());

				activosFijos.addAll(aux);
			}

			if (null != activoFijo.getSerial()) {

				ArrayList<ActivoFijo> aux = (ArrayList<ActivoFijo>) activoFijoRepository
						.getBySerial(activoFijo.getSerial());

				activosFijos.addAll(aux);
			}

			Set<ActivoFijo> hashSet = new HashSet<ActivoFijo>(activosFijos);
			activosFijos.clear();
			activosFijos.addAll(hashSet);

			return activosFijos;

		} catch (Exception e) {
			error = e;
			return null;
		}
	}

}
