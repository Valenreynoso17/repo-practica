package isi.died.parcial01.ejercicio02.app;

import java.util.List;

import isi.died.parcial01.ejercicio02.dominio.*;
import isi.died.parcial01.ejercicio02.excepciones.NoPoseeCorrelativasException;



public interface MySysAcad {
	
	public void registrarMateria(Materia d);
	
	
	public void registrarDocente(Docente d) ;
	
	
	public void registrarAlumnos(Alumno d);
	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 */
	public void inscribirAlumnoCursada(Docente d,Alumno a, Materia m,Integer cicloLectivo) throws NoPoseeCorrelativasException;

	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 */
	public void inscribirAlumnoExamen(Docente d,Alumno a, Materia m);
	
	/*
	 * Luego agregar a la interface MySysAcad el método "Double promedio(Docente d,Materia m)" 
	 * que retorna el promedio que obtuvieron quienes riendieron la materia M con el docente D, 
	 * usando expresiones lambdas.
	 */
	public default Double promedio(Docente d, Materia m) {
		
		Integer notaTotal = m.getExamenes().stream()
				  				.filter(mat -> mat.getDocente().equals(d))
				  				.map(e -> e.getNota())
				  				.reduce(0, (x,y) -> {return x+y;});
		
		Long cantTotal = m.getExamenes().stream()
  									    .filter(mat -> mat.getDocente().equals(d))
  									    .count();
		
		return (double) (notaTotal/cantTotal);
	}

	public List<Examen> buscarExamenesReprobados(Alumno a, Materia m);
	
}
