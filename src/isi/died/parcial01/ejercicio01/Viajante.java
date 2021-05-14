package isi.died.parcial01.ejercicio01;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import isi.died.parcial01.ejercicio01.enums.TipoProducto;

public class Viajante extends Empleado {
	
	public Viajante(String nombre, String cuit, String email, Double valorObjetivo) {
		super(nombre, cuit, email, valorObjetivo);
	}

	@Override
	public Double comision() {
		
		Double comision = 0.0;
		
		for(Venta unaVenta : this.listaVentasRealizadas) {
			
			// 1
			if(unaVenta.getTipo() == TipoProducto.AGRO) comision += unaVenta.getMontoTotal() * 1.1;
			
			// 2
			comision = comision + 1000 * this.cantClientes;
			
			// 3
			if (this.valorObjetivo >= this.calcularVentas()) comision *= 1.2;
			
			// 4
			if (unaVenta.getMesVenta() == 9) comision *= 2;
		}
		
		return comision;
	}
	
}
