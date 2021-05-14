package isi.died.parcial01.ejercicio01;

public class VendedorLocal extends Empleado{

	public VendedorLocal(String nombre, String cuit, String email, Double valorObjetivo) {
		super(nombre, cuit, email, valorObjetivo);
	}

	@Override
	public Double comision() {

		Double comision = 0.0;
		
		for(Venta unaVenta : this.listaVentasRealizadas) {
			// 1
			comision += unaVenta.getMontoTotal() * 0.05;
			
			// 2
			comision += (this.cantClientes / 100) * 1000;
			
			// 3
			if (this.valorObjetivo >= this.calcularVentas()) comision *= 1.2;
			
			// 4
			if (unaVenta.getMesVenta() == 9) comision *= 2;
		}
		
		return comision;
	}

}
