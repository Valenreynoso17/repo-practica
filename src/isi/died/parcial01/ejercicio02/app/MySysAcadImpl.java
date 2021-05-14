package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import isi.died.parcial01.ejercicio02.db.BaseDeDatos;
import isi.died.parcial01.ejercicio02.db.BaseDeDatosExcepcion;
import isi.died.parcial01.ejercicio02.dominio.*;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	

	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) {
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc);
		// DESCOMENTAR Y gestionar excepcion
		try {
			DB.guardar(insc);
		} catch (BaseDeDatosExcepcion e) {
			e.printStackTrace();
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}
	
	public void registrarNota(Examen e, Integer nota) {
		
		/*
		 * 
    	Setear la nota en el examen.
    	Si la nota es 6 o superior,
    	buscar el alumno y actualizar la última inscripción a esta materia como PROMOCIONADA.
		 */
		
		e.setNota(nota);
		
		if (nota >= 6) {
			e.getAlumno().promocionar(e.getMateria());
		}
	}

	/*
	 * Agregar el método public List<Examen> buscarExamenesReprobados(Alumno a, Materia m) 
	 * que lista los examenes no aprobados y los ordena de manera decreciente por fecha 
	 * (del mas nuevo al mas viejo )
	 */
	public List<Examen> buscarExamenesReprobados(Alumno a, Materia m){
		
		Comparator<Examen> orden = (e1, e2) -> e1.getFecha().compareTo(e2.getFecha());
		
		a.getExamenes().stream()
		  			   .filter(e -> e.getMateria().equals(m))
		  			   .filter(e -> e.getNota() < 6)
		  			   .sorted(orden.reversed());
		return null;
	}
}
