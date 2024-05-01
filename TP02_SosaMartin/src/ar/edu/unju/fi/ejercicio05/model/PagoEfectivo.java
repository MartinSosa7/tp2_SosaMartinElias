package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ar.edu.unju.fi.ejercicio05.interfaces.IPago;

public class PagoEfectivo implements IPago {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Double paidAmount;
	private LocalDate payoutDate;
	
	public PagoEfectivo() {
		this.payoutDate = LocalDate.now();
		this.paidAmount = 0d;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public LocalDate getPayoutDate() {
		return payoutDate;
	}

	public void setPayoutDate(LocalDate payoutDate) {
		this.payoutDate = payoutDate;
	}

	@Override
	public void realizarPago(double monto) {
		this.paidAmount = this.paidAmount - (this.paidAmount * 0.10);
		
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("\nFecha de Pago: "+this.payoutDate.format(FORMATTER)
				+ "\nMonto pagado: "+this.paidAmount);
		
	}
	
	
}
