package isi.died.parcial01.ejercicio01;

import java.util.ArrayList;
import java.util.List;

import isi.died.parcial01.ejercicio01.enums.TipoProducto;

public class VendedorOnline extends Empleado{
	
	public VendedorOnline(String nombre, String cuit, String email, Double valorObjetivo) {
		super(nombre, cuit, email, valorObjetivo);
	}

	@Override
	public Double comision() {
		
		Double comision = 0.0;
		
		for(Venta unaVenta : this.listaVentasRealizadas) {
			
			// 1
			if (unaVenta.getTipo() == TipoProducto.VETERINARIO) comision += unaVenta.getMontoTotal() * 1.25;
			else comision += unaVenta.getMontoTotal() * 1.2;
			
			// 2 
			comision += (this.cantClientes / 20) * 5000;
			
			// 3
			if (this.valorObjetivo >= this.calcularVentas()) comision *= 1.1;
			
			// 4
			if (unaVenta.getMesVenta() == 9) comision *= 2;
		}
		
		return comision;
	}

}
