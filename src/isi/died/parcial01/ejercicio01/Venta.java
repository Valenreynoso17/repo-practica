package isi.died.parcial01.ejercicio01;

import java.time.LocalDate;

import isi.died.parcial01.ejercicio01.enums.TipoProducto;

public class Venta {
	private String cliente;
	private LocalDate fechaVenta;
	private Double montoTotal;
	private TipoProducto tipoProducto;
	
	public Venta(String cliente, LocalDate fechaVenta, Double montoTotal, TipoProducto tipoProducto) {
		super();
		this.cliente = cliente;
		this.fechaVenta = fechaVenta;
		this.montoTotal = montoTotal;
		this.tipoProducto = tipoProducto;
	}
	
	public TipoProducto getTipo() {
		return this.tipoProducto;
	}
	
	public Double getMontoTotal() {
		return this.montoTotal;
	}
	
	public Integer getMesVenta() {
		return this.fechaVenta.getMonth().getValue();
	}
}
