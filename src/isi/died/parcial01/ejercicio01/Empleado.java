package isi.died.parcial01.ejercicio01;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
	protected String nombre;
	protected String cuit;
	protected String email;
	protected List<Venta> listaVentasRealizadas;
	protected Double valorObjetivo;
	protected Integer cantClientes; // Depende del tipo de empleado será contacto, visitado o atendido
	
	public Empleado(String nombre, String cuit, String email, Double valorObjetivo) {
		super();
		this.nombre = nombre;
		this.cuit = cuit;
		this.email = email;
		this.listaVentasRealizadas = new ArrayList<Venta>();
		this.valorObjetivo = valorObjetivo;
		this.cantClientes = 0;
	}
	
	public abstract Double comision();
	
	public Double calcularVentas() {
		return this.listaVentasRealizadas.stream().map(v -> v.getMontoTotal()).reduce(0.0, (x,y) -> {return x+y;});
	}
	
	// TODO: me parece horrible	
	public String reciboComisiones(Integer mes) { //Perdon por esto, no se de que tipo seria recibo, y pero me quedo lo del mes
		
		String recibo = "Recibo de comision de: " + Month.of(mes) + 
						"\n Realizo: " + this.listaVentasRealizadas.size() + " ventas. Con un costo total de: " + this.calcularVentas() +
						"\n Visito a: " + this.cantClientes + " clientes" +
						"\n Obtuvo en total: " + this.comision() + " de comision";
						
		return recibo;
	}
	
	
}
