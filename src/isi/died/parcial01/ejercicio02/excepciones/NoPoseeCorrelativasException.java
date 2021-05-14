package isi.died.parcial01.ejercicio02.excepciones;

public class NoPoseeCorrelativasException extends Exception{
	public NoPoseeCorrelativasException() {
		super("El alumno no posee las correlativas necesarias para inscribirse a esta materia.");
	}
}
