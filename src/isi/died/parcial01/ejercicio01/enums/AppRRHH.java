package isi.died.parcial01.ejercicio01.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import isi.died.parcial01.ejercicio01.Empleado;

public class AppRRHH {
	
	public List<String> algo(ArrayList<Empleado> arregloEmp, Integer mes){
		
		List<String> resultado = arregloEmp.stream().map(e -> e.reciboComisiones(mes)).collect(Collectors.toList());
		
		return resultado;
	}
}
